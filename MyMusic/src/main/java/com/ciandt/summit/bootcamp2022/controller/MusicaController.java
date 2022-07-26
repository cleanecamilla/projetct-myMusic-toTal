package com.ciandt.summit.bootcamp2022.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
@Tag(name = "Músicas")
public class MusicaController {
    @GetMapping
    @Operation(summary = "Buscar músicas/artistas",
            description = "Buscar músicas/artistas, não case sensitive e necessário 2 caracteres mínimo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "204", description = "Sem resultados"),
            @ApiResponse(responseCode = "400", description = "Caracteres insuficientes")})
    public ResponseEntity<?> buscarMusicas(@PathVariable(value = "filtro", required = false) String filtro) {
        if (filtro != null && !filtro.isEmpty() && filtro.length() < 2) {
            return ResponseEntity.badRequest().build();
        }

        //chamar service

        return ResponseEntity.ok(filtro);
    }
}
