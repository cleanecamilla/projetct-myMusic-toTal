package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.infra.config.TokenConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/musicas")
public class MusicController {

    @GetMapping
    public ResponseEntity<String> getMusic() {
        String token = TokenConfiguration.token;
        return ResponseEntity.ok(token);
    }
}
