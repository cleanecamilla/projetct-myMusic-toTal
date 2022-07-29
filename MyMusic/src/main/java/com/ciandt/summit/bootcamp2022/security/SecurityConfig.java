package com.ciandt.summit.bootcamp2022.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.ciandt.summit.bootcamp2022.security.Token.TokenInterceptor;


@Configuration
public class SecurityConfig implements WebMvcConfigurer {

    @Autowired
    TokenInterceptor tokenInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenInterceptor)
            .excludePathPatterns("/mymusic/swagger-ui/**")
            .excludePathPatterns("/mymusic/swagger-ui.html")
            .excludePathPatterns("/v3/api-docs/**")
            .excludePathPatterns("/mymusic/swagger-resources/**")
            .excludePathPatterns("/error")
            .addPathPatterns("/**");
    }

}
