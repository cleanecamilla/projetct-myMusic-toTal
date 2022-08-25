package com.ciandt.summit.bootcamp2022.domains.token.dto;

import java.util.Objects;

public class CreateAuthorizerDTO {
    private CreateAuthorizerDataDTO data;

    public CreateAuthorizerDTO(CreateAuthorizerDataDTO createAuthorizerData) {
        this.data = createAuthorizerData;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateAuthorizerDTO that = (CreateAuthorizerDTO) o;
        return Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }

    public CreateAuthorizerDataDTO getData() {
        return data;
    }

    public void setData(CreateAuthorizerDataDTO data) {
        this.data = data;
    }
}
