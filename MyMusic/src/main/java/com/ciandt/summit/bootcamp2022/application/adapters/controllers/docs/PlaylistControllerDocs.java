package com.ciandt.summit.bootcamp2022.application.adapters.controllers.docs;

import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.playlists.dtos.PlaylistSongsRequestDTO;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


public interface PlaylistControllerDocs {

    @ApiOperation("Add songs to existing playlist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Added songs successfully"),
            @ApiResponse(code = 400, message = "Could not find specified song(s) in the database")
    })
    ResponseEntity<?> addSongsToPlaylist(@PathVariable String playlistId,
                                                @RequestBody PlaylistSongsRequestDTO playlistSongsRequestDTO)
            throws SongsNotFoundException, PlaylistsNotFoundException;
}
