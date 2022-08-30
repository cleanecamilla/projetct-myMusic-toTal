package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.application.dtos.MusicDataDTO;
import com.ciandt.summit.bootcamp2022.domain.dtos.MusicDTO;
import com.ciandt.summit.bootcamp2022.domain.ports.interfaces.PlaylistServicePort;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController {

    private final PlaylistServicePort playlistServicePort;

    public PlaylistController(PlaylistServicePort playlistServicePort) {
        this.playlistServicePort = playlistServicePort;
    }

    @PutMapping("/{playlistId}/musicas")
    public ResponseEntity<MusicDataDTO> addMusicToPlaylist(@PathVariable String playlistId, @RequestBody MusicDataDTO data) {
        this.playlistServicePort.addMusicToPlaylist(playlistId, data.getMusicList().get(0));
        return ResponseEntity.status(HttpStatus.CREATED).body(data);
    }

    @PutMapping("/{playlistId}/musicas/{musicaId}")
    public ResponseEntity<Void> removeMusicFromPlaylist(@PathVariable String playlistId, @PathVariable String musicaId) {
        return null;
    }
}
