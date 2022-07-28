package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.common.response.ResponseData;
import com.ciandt.summit.bootcamp2022.controller.dto.MusicDto;
import com.ciandt.summit.bootcamp2022.service.MusicService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Size;

@RestController
@RequestMapping("/api/musicas")
@Tag(name = "Music")
@Validated
public class MusicController {
    MusicService musicService; //injeção de dependência pendente

    @GetMapping
    @Operation(summary = "Find songs/artists",
               description = "Find songs/artists. The search is not case sensitive. At least 2 characters are required."
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Operation success"),
            @ApiResponse(responseCode = "204", description = "No results"),
            @ApiResponse(responseCode = "400", description = "Not enough characters"),
            @ApiResponse(responseCode = "403", description = "Not authorized")
    })
    public ResponseEntity<ResponseData<MusicDto>> findMusics (
            @RequestParam(name = "filtro", required = false) @Size(min = 2) String filter) {
        //chamar service
        // tirar a size

        return ResponseEntity.ok(ResponseData.of(new MusicDto()));
    }
}
