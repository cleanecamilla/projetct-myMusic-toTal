package com.ciandt.summit.bootcamp2022.service.impl;

import com.ciandt.summit.bootcamp2022.dto.CreateAuthorizerRequest;
import com.ciandt.summit.bootcamp2022.dto.CreateAuthorizerRequestData;
import com.ciandt.summit.bootcamp2022.dto.CreateTokenRequest;
import com.ciandt.summit.bootcamp2022.dto.CreateTokenRequestData;
import com.ciandt.summit.bootcamp2022.exception.UserNotFoundException;
import com.ciandt.summit.bootcamp2022.service.TokenProviderService;
import com.ciandt.summit.bootcamp2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TokenProviderServiceImpl implements TokenProviderService {

    private final UserService userService;

    @Override
    public String getToken(String username) {

        if (!userService.findByUsername(username).isPresent()){
            throw new UserNotFoundException();
        }

        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8081/api/v1/token";
        CreateTokenRequestData tokenRequestData = CreateTokenRequestData
                                                    .builder()
                                                    .name(username)
                                                    .build();
        CreateTokenRequest tokenRequest = CreateTokenRequest
                                            .builder()
                                            .data(tokenRequestData)
                                            .build();
        return restTemplate.postForEntity(url, tokenRequest, String.class).getBody();
    }

    @Override
    public boolean isTokenValid(String username, String token) {
        try {
            RestTemplate restTemplate = new RestTemplate();
            String url = "http://localhost:8081/api/v1/token/authorizer";
            CreateAuthorizerRequestData authorizerRequestData = CreateAuthorizerRequestData
                    .builder()
                    .name(username)
                    .token(token)
                    .build();
            CreateAuthorizerRequest authorizerRequest = CreateAuthorizerRequest
                    .builder()
                    .data(authorizerRequestData)
                    .build();
            restTemplate.postForEntity(url, authorizerRequest, String.class);
            return true;
        } catch (Exception restTemplateException){
            return false;
        }
    }
}
