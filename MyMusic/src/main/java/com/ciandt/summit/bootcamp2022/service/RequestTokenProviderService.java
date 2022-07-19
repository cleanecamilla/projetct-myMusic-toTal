package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.controller.dto.request.CreateAuthorizerRequest;
import com.ciandt.summit.bootcamp2022.controller.dto.request.CreateAuthorizerRequestData;

import org.springframework.stereotype.Service;

import org.springframework.web.client.RestTemplate;

@Service
public class RequestTokenProviderService {

    public boolean validateToken(String[] token){

        RestTemplate restTemplate = new RestTemplate();

        try {
            restTemplate.postForEntity("http://localhost:8081/api/v1/token/authorizer",
                    new CreateAuthorizerRequest(new CreateAuthorizerRequestData(token[0], token[1])), String.class);
                return true;
        }  catch (Exception e){
            return false;
        }

    }
}
