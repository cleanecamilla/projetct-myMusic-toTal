package com.ciandt.summit.bootcamp2022.interceptor.request;

public class TokenAuthorizerRequest {

    private Data data;

    public TokenAuthorizerRequest(Data data) {
        this.data = data;
    }

    public Data getData() {
        return data;
    }

    public static class Data{

        private String name;
        private String token;

        public Data(String name, String token) {
            this.name = name;
            this.token = token;
        }

        public String getName() {
            return name;
        }

        public String getToken() {
            return token;
        }
    }
}


