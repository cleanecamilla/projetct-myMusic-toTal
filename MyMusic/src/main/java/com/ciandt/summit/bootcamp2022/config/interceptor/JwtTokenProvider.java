package com.ciandt.summit.bootcamp2022.config.interceptor;

import com.ciandt.summit.bootcamp2022.controller.dto.request.CreateAuthorizerRequest;
import com.ciandt.summit.bootcamp2022.controller.dto.request.CreateAuthorizerRequestData;
import com.ciandt.summit.bootcamp2022.service.RequestTokenProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class JwtTokenProvider {

    @Autowired
    private RequestTokenProviderService requestTokenProviderService;
    Boolean validateCredentials(String[] token){
        return requestTokenProviderService.validateToken(token);
    }
}
