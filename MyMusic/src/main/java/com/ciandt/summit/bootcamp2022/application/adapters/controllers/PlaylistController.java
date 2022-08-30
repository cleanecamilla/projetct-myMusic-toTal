package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.PlaylistServicePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/api/playlists")
public class PlaylistController {

    private final PlaylistServicePort playlistServicePort;

    public PlaylistController(PlaylistServicePort playlistServicePort) {
        this.playlistServicePort = playlistServicePort;
    }

    @PutMapping("/{playlistId}/musicas")
    public ResponseEntity<MusicDTO> addMusicToPlaylist(@PathVariable String playlistId, @RequestBody MusicDTO musicDTO) {
        return null;
    }

    @PutMapping("/{playlistId}/musicas/{musicaId}")
    public ResponseEntity<Void> removeMusicFromPlaylist(@PathVariable String playlistId, @PathVariable String musicaId) {
        return null;
    }
}
