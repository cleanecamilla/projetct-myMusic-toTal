package com.ciandt.summit.bootcamp2022.infra.feignclients;

import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Component
@FeignClient(name = "token-provider", url = "localhost:8080", path = "/api/v1/token/authorizer")
public interface TokenProvider {
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> createTokenAuthorizer(@RequestBody CreateAuthorizerDTO createAuthorizer);
}
