package com.ciandt.summit.bootcamp2022.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/musicas")
@Tag(name = "Músicas")
public class MusicaController {
    //instância de service

    @GetMapping
    @Validated
    @Operation(summary = "Buscar músicas/artistas",
            description = "Buscar músicas/artistas, não case sensitive e necessário 2 caracteres mínimo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "204", description = "Sem resultados"),
            @ApiResponse(responseCode = "400", description = "Caracteres insuficientes")})
    public ResponseEntity<?> buscarMusicas(@Valid @RequestParam(name = "filtro", required = false) @Size(min = 2) String filtro) {

        //chamar service

        return ResponseEntity.ok(filtro);
    }
}
