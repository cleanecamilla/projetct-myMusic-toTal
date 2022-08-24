package com.ciandt.summit.bootcamp2022.application.adapters.controllers;

import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Api("MyMusic")
public interface MusicControllerDocs {

    @ApiOperation(value = "Get a song")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Song successfully located!"),
            @ApiResponse(code = 204, message = "Song not found")})
    public ResponseEntity<String> get();

    @ApiOperation(value = "Find song by name or artist")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Song located by name or artist!"),
            @ApiResponse(code = 204, message = "Song not found"),
            @ApiResponse(code = 400, message = "search with less than 2 characters invalid")})
    public ResponseEntity<List<SongDTO>> findSongsByNameOrArtistName(@RequestParam(name = "filtro") String filter);
}
