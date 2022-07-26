package com.ciandt.summit.bootcamp2022.service;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ciandt.summit.bootcamp2022.exception.MissingCredentialsException;
import com.ciandt.summit.bootcamp2022.exception.RequestTokenProviderException;
import com.ciandt.summit.bootcamp2022.security.Token.TokenDTO;

@Service
public class TokenServices {

    private final String TOKEN_PROVIDER_URL = "http://localhost:8080/api/v1/token";
    private final String TOKEN_PROVIDER_AUTHENTICATION_PATH = "/authorizer";

    public boolean isAuthorized(HttpServletRequest request) throws Exception {
        List<String> credentials = getCredentials(request);
        TokenDTO tokenAuthorizerDto = new TokenDTO(credentials.get(0), credentials.get(1)); // name and token
        
        ResponseEntity<String> responseTokenProvider = getApiAuthenticationResponse(tokenAuthorizerDto);

        if(responseTokenProvider.getBody().equals("ok")) {
            return true;
        }else
            return false;
    }
    
    private List<String> getCredentials(HttpServletRequest request) throws MissingCredentialsException {
        try {
            String authorizationHeader = request.getHeader("Authorization");
            String base64Credentials = authorizationHeader.substring("Basic".length()).trim();
        
            byte[] credDecoded = Base64.getDecoder().decode(base64Credentials);
            String credentials = new String(credDecoded, StandardCharsets.UTF_8);
            
            return List.of(credentials.split(":"));
        } catch(Exception e) {
            throw new MissingCredentialsException("Credentials missing or not in Basic Auth format");
        }
    }

    private ResponseEntity<String> getApiAuthenticationResponse(TokenDTO tokenDto) throws RequestTokenProviderException {
        try {
            final String URI = this.TOKEN_PROVIDER_URL + this.TOKEN_PROVIDER_AUTHENTICATION_PATH;
            HttpEntity<TokenDTO> requestTokenApi = new HttpEntity<>(tokenDto);

            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<String> apiResponse = restTemplate.postForEntity(URI, requestTokenApi, String.class);

            return apiResponse;
        } catch (Exception e) {
            throw new RequestTokenProviderException("TokenProvider Api cannot be reached");
        }
    }

}
