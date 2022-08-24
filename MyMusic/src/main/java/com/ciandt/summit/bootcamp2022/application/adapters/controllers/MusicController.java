package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.infra.adapters.entities.ArtistEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/musicas")
public class MusicController {


    @GetMapping
    public ResponseEntity<String> getMusic() {
        return ResponseEntity.ok("Authorization ok!!");
    }

    @GetMapping(value = "/musicas")
    public List<T> findMusicByName(@RequestParam("name") String name) {

    }
}
