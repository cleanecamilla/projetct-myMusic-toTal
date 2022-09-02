package com.ciandt.summit.bootcamp2022.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Schema(name = "AuthRequest", description = "Model used for authentication")
public class AuthRequest {
    @Schema(required = true, description = "Unique name that represents an User in database")
    private String username;
}
