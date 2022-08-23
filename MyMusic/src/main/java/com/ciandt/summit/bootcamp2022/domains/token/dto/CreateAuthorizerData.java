package com.ciandt.summit.bootcamp2022.domains.token.dto;

import java.util.Objects;

public class CreateAuthorizerData {
    private String token;
    private String name;

    public CreateAuthorizerData(String token, String name) {
        this.token = token;
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
