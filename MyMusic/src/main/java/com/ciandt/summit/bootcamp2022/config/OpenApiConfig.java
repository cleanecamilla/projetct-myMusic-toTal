package com.ciandt.summit.bootcamp2022.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.media.StringSchema;
import io.swagger.v3.oas.models.parameters.Parameter;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI springShopOpenAPI() {
        String securitySchemeName = "ApiKeyAuth";
        return new OpenAPI()
                .info(new Info().title("My Music")
                        .description("My Music API Documentation")
                        .version("v1.0.0"))
                .addSecurityItem(new SecurityRequirement().addList(securitySchemeName))
                .components(
                        new Components()
                                .addSecuritySchemes("api_key", new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)
                                        .description("Basic token authentication")
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Authorization")
                                ).addParameters("Version", new Parameter()
                                        .in("header")
                                        .name("Version")
                                        .schema(new StringSchema())
                                        .required(false)))
                .security(Arrays.asList(
                        new SecurityRequirement().addList("spring_oauth"),
                        new SecurityRequirement().addList("api_key")));
    }

}