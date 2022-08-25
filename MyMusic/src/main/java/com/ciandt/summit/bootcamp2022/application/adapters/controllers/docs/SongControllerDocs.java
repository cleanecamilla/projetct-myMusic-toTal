package com.ciandt.summit.bootcamp2022.application.adapters.controllers.docs;

import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.InvalidSongNameOrArtistNameException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

// TODO: update this after changes in BOOT-812
public interface SongControllerDocs {
    @ApiOperation(value = "Find songs by name or artist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Found songs"),
            @ApiResponse(code = 204, message = "Songs not found"),
            @ApiResponse(code = 401, message = ""),
            @ApiResponse(code = 400, message = "filter with less than 2 characters invalid")})
    ResponseEntity<List<SongDTO>> findSongsByNameOrArtistName(@RequestParam(name = "filtro") String filter)
            throws SongsNotFoundException, InvalidSongNameOrArtistNameException;
}
