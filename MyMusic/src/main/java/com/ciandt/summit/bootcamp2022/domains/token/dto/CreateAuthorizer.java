package com.ciandt.summit.bootcamp2022.domains.token.dto;

import java.util.Objects;

public class CreateAuthorizer {
    private CreateAuthorizerData createAuthorizerData;

    public CreateAuthorizer(CreateAuthorizerData createAuthorizerData) {
        this.createAuthorizerData = createAuthorizerData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAuthorizer that = (CreateAuthorizer) o;
        return Objects.equals(createAuthorizerData, that.createAuthorizerData);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createAuthorizerData);
    }

    public CreateAuthorizerData getCreateAuthorizerData() {
        return createAuthorizerData;
    }

    public void setCreateAuthorizerData(CreateAuthorizerData createAuthorizerData) {
        this.createAuthorizerData = createAuthorizerData;
    }
}
