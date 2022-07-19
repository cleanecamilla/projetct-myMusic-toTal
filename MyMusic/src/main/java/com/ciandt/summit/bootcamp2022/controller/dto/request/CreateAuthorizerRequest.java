package com.ciandt.summit.bootcamp2022.controller.dto.request;

public class CreateAuthorizerRequest {

    private CreateAuthorizerRequestData data;

    public CreateAuthorizerRequest(CreateAuthorizerRequestData data) {
        this.data = data;
    }

    public CreateAuthorizerRequestData getData() {
        return data;
    }

    public void setData(CreateAuthorizerRequestData data) {
        this.data = data;
    }
}
