package com.ciandt.summit.bootcamp2022.controller;

import com.ciandt.summit.bootcamp2022.controller.dto.MusicaDto;
import com.ciandt.summit.bootcamp2022.entity.Musica;
import com.ciandt.summit.bootcamp2022.service.PlayListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.security.Provider;
@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    @Autowired
    private PlayListService playListService;

    @PostMapping("/{playlistId}/musicas")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<MusicaDto> adicionarMusicasNaPLaylist(@RequestBody Musica musica, @PathVariable(name = "playlistId") String idPlayList){
        MusicaDto musicaDto = playListService.adicionarMusicaNaPlayList(musica, idPlayList);
        URI uri = UriComponentsBuilder.fromPath("Playlist").buildAndExpand(musicaDto).toUri();
        return ResponseEntity.created(uri).body(musicaDto);
    }


}
