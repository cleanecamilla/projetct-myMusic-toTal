package com.ciandt.summit.bootcamp2022.application.adapters.controllers.handlers;

import com.ciandt.summit.bootcamp2022.domains.token.exceptions.BadAuthRequestException;
import com.ciandt.summit.bootcamp2022.domains.token.exceptions.UnauthorizedException;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDTO;
import com.ciandt.summit.bootcamp2022.domains.token.dto.CreateAuthorizerDataDTO;
import com.ciandt.summit.bootcamp2022.infra.feignclients.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Autowired
    private TokenProvider tokenProvider;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String user = request.getHeader("user");
        String token = request.getHeader("token");

        boolean userInvalid = user == null || user.isBlank();
        boolean tokenInvalid = token == null || token.isBlank();

        if (userInvalid || tokenInvalid) {
            throw new BadAuthRequestException("Auth headers not found: user or token are blank or null");
        }

        CreateAuthorizerDataDTO createAuthorizerData = new CreateAuthorizerDataDTO(token, user);
        CreateAuthorizerDTO createAuthorizer = new CreateAuthorizerDTO(createAuthorizerData);

        ResponseEntity<String> tokenProviderResponse = null;

        try {
            tokenProviderResponse = tokenProvider.createTokenAuthorizer(createAuthorizer);
        } catch (ResponseStatusException e) {
            if (e.getStatus().equals(HttpStatus.BAD_REQUEST) && e.getReason().equals("Token expirado")) {
                throw new UnauthorizedException("User unauthorized");
            }
        }

        if (tokenProviderResponse != null && tokenProviderResponse.getBody().equals("ok")) {
            return true;
        }

        return false;
    }
}
