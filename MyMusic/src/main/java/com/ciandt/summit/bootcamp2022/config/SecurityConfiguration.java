package com.ciandt.summit.bootcamp2022.config;

import com.ciandt.summit.bootcamp2022.service.TokenProviderService;
import com.ciandt.summit.bootcamp2022.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private static final RequestMatcher PROTECTED_URLS = new OrRequestMatcher(
            new AntPathRequestMatcher("/api/v1/music")
    );
    private final AuthenticationConfiguration configuration;

    private final TokenProviderService tokenProviderService;

    private final UserService userService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.formLogin().disable();
        http
                .authorizeHttpRequests()
                .requestMatchers(PROTECTED_URLS).authenticated()
                .anyRequest()
                .permitAll()
                .and()
                .csrf().disable()
                .addFilterBefore(authenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    AuthenticationManager authenticationManager() throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public CustomAuthenticationFilter authenticationFilter() throws Exception {
        CustomAuthenticationFilter authenticationFilter = new CustomAuthenticationFilter(PROTECTED_URLS, tokenProviderService, userService);
        authenticationFilter.setAuthenticationManager(authenticationManager());
        return authenticationFilter;
    }
}
