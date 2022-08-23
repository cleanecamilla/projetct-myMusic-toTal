package com.ciandt.summit.bootcamp2022.domains.token.dto;

import java.util.Objects;

public class CreateAuthorizer {
    private CreateAuthorizerData createAuthorizerData;

    public CreateAuthorizer(CreateAuthorizerData createAuthorizerData) {
        this.createAuthorizerData = createAuthorizerData;
    }

    public CreateAuthorizerData getCreateAuthorizerData() {
        return createAuthorizerData;
    }

    public void setCreateAuthorizerData(CreateAuthorizerData createAuthorizerData) {
        this.createAuthorizerData = createAuthorizerData;
    }
}
