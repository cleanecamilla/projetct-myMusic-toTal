package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.application.adapters.controllers.docs.PlaylistControllerDocs;
import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.dtos.PlaylistSongsRequestDTO;
import com.ciandt.summit.bootcamp2022.domains.playlists.ports.interfaces.PlaylistServicePort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/playlists")
public class PlaylistController implements PlaylistControllerDocs {

    @Autowired
    private PlaylistServicePort playlistServicePort;

    @PostMapping("/{playlistId}/musicas")
    public ResponseEntity<?> addSongsToPlaylist(@PathVariable String playlistId,
                                                @RequestBody PlaylistSongsRequestDTO playlistSongsRequestDTO)
            throws SongsNotFoundException, PlaylistsNotFoundException {

        playlistServicePort.addSongsToPlaylist(playlistId, playlistSongsRequestDTO.getData());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
