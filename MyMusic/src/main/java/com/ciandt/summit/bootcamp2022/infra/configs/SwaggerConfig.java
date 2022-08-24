package com.ciandt.summit.bootcamp2022.infra.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    private static final String BASE_PACKAGE = "com.application.adapters.controllers";
    private static final String API_TITLE = "MyMusic";
    private static final String API_DESCRIPTION = "_**API Rest para busca de musicas.**_";
    private static final String CONTACT_NAME = "Grupo 5 - junho - Checker Lovers";
    private static final String CONTACT_GITHUB = "https://github.com/joaobohana-ciandt/myMusic-CheckerLovers";
    private static final String CONTACT_EMAIL = "rsousa@ciandt.com, jbohana@ciandt.com, mlewartoski@ciandt.com, joaovg@ciandt.com, " +
            "jnakabar@ciandt.com";

    @Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {
        return new ApiInfoBuilder()
                .title(API_TITLE)
                .description(API_DESCRIPTION)
                .version("0.0.1")
                .contact(new Contact(CONTACT_NAME, CONTACT_GITHUB, CONTACT_EMAIL))
                .build();
    }
}
