package com.ciandt.summit.bootcamp2022.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTokenRequest {

    public CreateTokenRequestData getData() {
        return data;
    }

    public void setData(CreateTokenRequestData data) {
        this.data = data;
    }

    private CreateTokenRequestData data;


}
