package com.ciandt.summit.bootcamp2022.infra.config;

import com.ciandt.summit.bootcamp2022.infra.config.tokenAuth.AuthTokenFilter;
import com.ciandt.summit.bootcamp2022.infra.config.tokenAuth.CustomAuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.AnonymousAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.OrRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.Filter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomAuthenticationProvider tokenAuth;

    public SecurityConfig(CustomAuthenticationProvider tokenAuth) {
        this.tokenAuth = tokenAuth;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().disable()
                .csrf().disable()
                .formLogin().disable()
                .logout().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().authenticationProvider(tokenAuth)
                .addFilterBefore(buildTokenFilter(), AnonymousAuthenticationFilter.class).authorizeRequests()
                .requestMatchers(getRequestMatcher()).authenticated();
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/webjars/**");
    }

    private RequestMatcher getRequestMatcher() {
        return new OrRequestMatcher(new AntPathRequestMatcher("/**"));
    }

    private Filter buildTokenFilter() throws Exception {
        return new AuthTokenFilter(getRequestMatcher(), authenticationManager());
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(tokenAuth);
    }
}
