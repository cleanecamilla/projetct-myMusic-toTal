package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.InvalidSongNameOrArtistNameException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.interfaces.SongServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MusicController {

    @Autowired
    private SongServicePort songServicePort;

    @GetMapping("/musicas")
    public ResponseEntity<List<SongDTO>> findSongsByNameOrArtistName(@RequestParam(name = "filtro") String filter)
            throws SongsNotFoundException, InvalidSongNameOrArtistNameException {

        List<SongDTO> list = songServicePort.findByNameOrArtistName(filter, 10);
        return ResponseEntity.ok().body(list);
    }
}
