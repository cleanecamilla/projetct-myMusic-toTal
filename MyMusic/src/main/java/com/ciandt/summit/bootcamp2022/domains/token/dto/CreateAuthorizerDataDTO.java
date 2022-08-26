package com.ciandt.summit.bootcamp2022.domains.token.dto;

import java.util.Objects;

public class CreateAuthorizerDataDTO {
    private String token;
    private String name;

    public CreateAuthorizerDataDTO(String token, String name) {
        this.token = token;
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAuthorizerDataDTO that = (CreateAuthorizerDataDTO) o;
        return Objects.equals(token, that.token) && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(token, name);
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
