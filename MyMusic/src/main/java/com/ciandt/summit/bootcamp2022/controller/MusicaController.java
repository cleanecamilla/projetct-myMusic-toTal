package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.DTO.DataDTO;
import com.ciandt.summit.bootcamp2022.service.MusicaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/musicas")
@Tag(name = "Músicas")
@Validated
public class MusicaController {
    @Autowired
    MusicaService musicaService;

    @GetMapping
    @Operation(summary = "Buscar músicas/artistas",
            description = "Buscar músicas/artistas, não case sensitive e necessário 2 caracteres mínimo")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operação bem sucedida"),
            @ApiResponse(responseCode = "204", description = "Sem resultados"),
            @ApiResponse(responseCode = "400", description = "Caracteres insuficientes")})
    public ResponseEntity<DataDTO> buscarMusicas(@RequestParam(name = "filtro", required = false) @Size(min = 2, message = "lorem ipsum") String filtro) {

        DataDTO dataDTO = new DataDTO();//chamar service

        return ResponseEntity.ok(dataDTO);
    }
}
