package com.ciandt.summit.bootcamp2022.security.Token;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.ciandt.summit.bootcamp2022.service.TokenServices;

@Component
public class TokenInterceptor implements HandlerInterceptor {

    @Autowired
    private TokenServices tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return tokenService.isAuthorized(request);
    }

}
