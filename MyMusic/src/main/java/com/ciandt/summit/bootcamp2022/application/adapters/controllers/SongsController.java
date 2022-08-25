package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.InvalidSongNameOrArtistNameException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongResponseDTO;
import com.ciandt.summit.bootcamp2022.domains.songs.ports.interfaces.SongServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SongsController {

    @Autowired
    private SongServicePort songServicePort;

    @GetMapping("/musicas")
    @ResponseBody
    public ResponseEntity<SongResponseDTO> findSongsByNameOrArtistName(@RequestParam(name = "filtro") String filter)
            throws SongsNotFoundException, InvalidSongNameOrArtistNameException {

        SongResponseDTO response = songServicePort.findByNameOrArtistName(filter, 10);
        return ResponseEntity.ok().body(response);
    }
}
