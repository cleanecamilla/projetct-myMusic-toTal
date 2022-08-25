package com.ciandt.summit.bootcamp2022.config;

import com.ciandt.summit.bootcamp2022.entity.User;
import com.ciandt.summit.bootcamp2022.exception.InvalidTokenException;
import com.ciandt.summit.bootcamp2022.exception.UserNotFoundException;
import com.ciandt.summit.bootcamp2022.service.TokenProviderService;
import com.ciandt.summit.bootcamp2022.service.UserService;
import com.ciandt.summit.bootcamp2022.util.EncodeUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private final TokenProviderService tokenProviderService;

    private final UserService userService;

    CustomAuthenticationFilter(RequestMatcher requiresAuthenticationRequestMatcher, TokenProviderService tokenProviderService, UserService userService) {
        super(requiresAuthenticationRequestMatcher);
        this.tokenProviderService = tokenProviderService;
        this.userService = userService;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String base64 = getBase64FromRequest(request);
        String username = EncodeUtil.decodeUsername(base64);
        String token = EncodeUtil.decodeToken(base64);

        if (!tokenProviderService.isTokenValid(username, token)){
            throw new InvalidTokenException();
        }

        return createAuthenticationFromUsername(username);
    }

    private String getBase64FromRequest(HttpServletRequest request){
        String authHeader = request.getHeader("Authorization");

        if (!isBasic(authHeader)){
            throw new InvalidTokenException();
        }

        return authHeader.replace("Basic ", "");
    }

    private Authentication createAuthenticationFromUsername(String username){
        User user = userService.findByUsername(username)
                .orElseThrow(UserNotFoundException::new);

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return authentication;
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        SecurityContextHolder.getContext().setAuthentication(authResult);
        chain.doFilter(request, response);
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
                failed.getMessage());
    }

    private boolean isBasic(String header){
        return header.contains("Basic ");
    }

}
