package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.controller.dto.MusicaDto;
import com.ciandt.summit.bootcamp2022.service.MusicaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/music")
public class MusicController {

    @Autowired
    private MusicaService service;

    @GetMapping
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("67f5976c-eb1e-404e-8220-2c2a8a23be47");
    }
    @GetMapping("/buscar")
    public ResponseEntity<Object> buscar(@RequestParam(name = "filtro") String filtro){
        MusicaDto musicas = service.buscar(filtro);
        if(musicas.getData().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body(musicas);
        }
        return ResponseEntity.ok(new Gson().toJson(musicas));
    }
}