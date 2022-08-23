package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.ArtistEntity;
import com.ciandt.summit.bootcamp2022.infra.adapters.entities.MusicEntity;
import com.ciandt.summit.bootcamp2022.infra.adapters.repositories.SpringMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/musicas")
public class MusicController {

    @Autowired
    MusicServicePort musicServicePort;



    @GetMapping
    public ResponseEntity<String> getMusic() {
        return ResponseEntity.ok("67f5976c-eb1e-404e-8220-2c2a8a23be47");
    }

}
