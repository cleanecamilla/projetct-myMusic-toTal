package com.ciandt.summit.bootcamp2022.interceptor;

import com.ciandt.summit.bootcamp2022.exception.UsuarioNaoAutorizadoException;
import com.ciandt.summit.bootcamp2022.interceptor.request.TokenAuthorizerRequest;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class Interceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(Interceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("Requisição interceptada: " + request.getHeader("Authorization"));

        if(request.getHeader("Authorization") == null) {
            logger.error("Requisicao nao autorizada / Authorization Header nao encontrado.");
            throw new UsuarioNaoAutorizadoException("Usuario nao autenticado.");
        }

        String upd = request.getHeader("Authorization");
        String pair = new String(Base64.decodeBase64(upd.substring(6)));

        if(pair.length() == 1 || pair.split(":").length < 2) {
            logger.error("Requisicao nao autorizada / Authorization Header esta faltando user e/ou password.");
            throw new UsuarioNaoAutorizadoException("Usuario nao autenticado.");
        }

        String userName = pair.split(":")[0];
        String password = pair.split(":")[1];

        logger.info("Decodificando Authorization");
        logger.info("Username: " + userName);
        logger.info("Password: " + password);

        RestTemplate restTemplate = new RestTemplate();
        final String baseUrl = "http://localhost:8081/api/v1/token/authorizer";
        URI uri = new URI(baseUrl);
        TokenAuthorizerRequest tokenAuthorizerRequest = new TokenAuthorizerRequest(new TokenAuthorizerRequest.Data(userName, password));

        HttpEntity<TokenAuthorizerRequest> reqTokenApi = new HttpEntity<>(tokenAuthorizerRequest);

        try{
            ResponseEntity<String> responseTokenApi = restTemplate.postForEntity(uri, reqTokenApi, String.class);
            if(responseTokenApi.getBody().equals("ok")) {
                logger.info("Autenticacao realizada com sucesso.");
                return true;
            }else
                return false;
        }catch(Exception ex){
            logger.error("Requisição não autorizada pelo TokenProvider.");
            throw new UsuarioNaoAutorizadoException("Usuario nao autenticado.");
        }
    }
}