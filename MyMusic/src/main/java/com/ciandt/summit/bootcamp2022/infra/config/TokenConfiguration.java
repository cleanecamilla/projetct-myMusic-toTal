package com.ciandt.summit.bootcamp2022.infra.config;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


@Configuration
public class TokenConfiguration {


    public static String token;

    @Value("${user}")
    public String username;

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

    @Bean
    public CommandLineRunner generateToken(RestTemplate restTemplate) throws Exception {
        return args -> {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            JSONObject data = new JSONObject();
            JSONObject user = new JSONObject();
            user.put("name", username);
            data.put("data", user);

            HttpEntity<String> request = new HttpEntity<>(data.toString(), headers);
            token = restTemplate.postForObject("http://localhost:8080/api/v1/token", request, String.class);
            //token = response.toString();
            System.out.println("==================================================");
            System.out.println("Token: " + token);
            System.out.println("==================================================");
        };
    }

/*    public static boolean authenticateToken() {

    }*/

}
