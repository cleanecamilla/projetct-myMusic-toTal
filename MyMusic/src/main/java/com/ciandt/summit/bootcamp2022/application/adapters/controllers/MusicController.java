package com.ciandt.summit.bootcamp2022.application.adapters.controllers;


import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.MusicServicePort;
import com.ciandt.summit.bootcamp2022.exceptions.InvalidParameterException;
import com.ciandt.summit.bootcamp2022.exceptions.NoContentException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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

    @GetMapping
    public ResponseEntity<Set<MusicDTO>> findMusicByName(@RequestParam("name") String name) {
        if(name == null || name.length() < 2)
            throw new InvalidParameterException("O termo buscado deve ter pelo menos 2 caracteres.");
        if(musicServicePort.getMusicsByFilter(name).isEmpty())
            return ResponseEntity.noContent().build();
        else
            return ResponseEntity.ok(musicServicePort.getMusicsByFilter(name));
    }

    @PostMapping(value = "/playlists")
    @ResponseStatus(HttpStatus.CREATED)
    public void addMusics(@RequestBody MusicDTO musicDTO) {
        musicServicePort.addMusic(musicDTO);
    }
}
