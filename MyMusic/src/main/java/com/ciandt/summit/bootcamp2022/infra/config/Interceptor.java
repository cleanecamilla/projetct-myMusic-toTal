package com.ciandt.summit.bootcamp2022.infra.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@Component
public class Interceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (request.getHeader("Authorization") == null) {
            log.info("Authorization token not sent.");
            response.setStatus(401);
            return false;
        } else if (request.getHeader("Authorization").equals(TokenConfiguration.token)) {
            log.info("Authorization OK");
            return true;
        } else {
            response.setStatus(401);
            log.info("Authentication failed: Invalid token.");
            return false;
        }
    }
}
