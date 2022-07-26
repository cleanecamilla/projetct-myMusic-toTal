package com.ciandt.summit.bootcamp2022.security.Token;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class TokenDTO {
    private Data data;

    public TokenDTO(String name, String token) {
        this.data = new Data(name, token);
    }

    @AllArgsConstructor
    @Getter
    class Data {
        private String name;
        private String token;
    }
}
