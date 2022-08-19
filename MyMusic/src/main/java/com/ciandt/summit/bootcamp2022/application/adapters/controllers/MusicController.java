package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
public class MusicController {

    @GetMapping
    public ResponseEntity<String> getMusic() {
        return ResponseEntity.ok("67f5976c-eb1e-404e-8220-2c2a8a23be47");
    }
}
