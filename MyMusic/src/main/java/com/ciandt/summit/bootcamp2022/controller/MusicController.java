package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.SummitBootcampApplication;
import com.ciandt.summit.bootcamp2022.controller.dto.MusicaDto;
import com.ciandt.summit.bootcamp2022.service.MusicaService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {

    private static final Logger LOGGER = LoggerFactory.getLogger(SummitBootcampApplication.class);
    @Autowired
    private MusicaService service;

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("67f5976c-eb1e-404e-8220-2c2a8a23be47");
    }

    @GetMapping("/buscar")
    public ResponseEntity<MusicaDto> buscar(@RequestParam(name = "filtro") String filtro){

        LOGGER.info("Acessando método de buscar musicas por filtro!");
        MusicaDto musicas = service.buscar(filtro);

        if(musicas.getData().isEmpty()){
            LOGGER.info("Musicas não encontradas");
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(musicas);
        }

        LOGGER.info("Musicas retornadas com sucesso!");
        return ResponseEntity.ok(musicas);
    }
}