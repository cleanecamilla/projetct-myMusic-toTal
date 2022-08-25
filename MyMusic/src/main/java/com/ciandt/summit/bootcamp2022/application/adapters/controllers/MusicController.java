package com.ciandt.summit.bootcamp2022.application.adapters.controllers;


import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping("/api/musicas")
public class MusicController {

    final MusicServicePort musicServicePort;


    public MusicController(MusicServicePort musicServicePort) {
        this.musicServicePort = musicServicePort;
    }

    @GetMapping(value = "/all")
    public ResponseEntity<Set<MusicDTO>> getMusic() {
        return ResponseEntity.ok(musicServicePort.searchMusics());
    }

    @GetMapping(value = "/music")
    public ResponseEntity<Set<MusicDTO>> findMusicByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(musicServicePort.getMusicsByFilter(name));
    }

    @PostMapping(value = "/playlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMusics(@RequestBody MusicDTO musicDTO) {
        musicServicePort.addMusic(musicDTO);
    }
}
