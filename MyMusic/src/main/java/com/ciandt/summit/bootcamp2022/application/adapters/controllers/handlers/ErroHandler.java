package com.ciandt.summit.bootcamp2022.application.adapters.controllers.handlers;

import com.ciandt.summit.bootcamp2022.domains.exceptions.playlists.PlaylistsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.InvalidSongNameOrArtistNameException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.songs.SongsNotFoundException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.tokens.BadAuthRequestException;
import com.ciandt.summit.bootcamp2022.domains.exceptions.tokens.UnauthorizedException;
import com.ciandt.summit.bootcamp2022.domains.playlists.Playlist;
import com.ciandt.summit.bootcamp2022.domains.songs.Song;
import com.ciandt.summit.bootcamp2022.domains.songs.dtos.SongDTO;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Date;

@ControllerAdvice
@RestController
public class ErroHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExceptionResponse> handlerAllExceptions (Exception exception, WebRequest request){
        ExceptionResponse exceptionResponse = new ExceptionResponse(
                new Date(), exception.getMessage(), request.getDescription(false)
        );
        return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(SongsNotFoundException.class)
    public final ResponseEntity<ArrayList<SongDTO>> handlerSongNotFoundExceptions (Exception exception, WebRequest request){
        ArrayList<SongDTO> songDTOS = new ArrayList<>();
        return new ResponseEntity<>(songDTOS, HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(InvalidSongNameOrArtistNameException.class)
    public final ResponseEntity<SongDTO> handlerInvalidSongNameExceptions (Exception exception, WebRequest request){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(BadAuthRequestException.class)
    public final ResponseEntity<SongDTO> handlerBadRequestExceptions (Exception exception, WebRequest request){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public final ResponseEntity<SongDTO> handlerUnauthorizedExceptions (Exception exception, WebRequest request){
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(PlaylistsNotFoundException.class)
    public final ResponseEntity<ArrayList<Playlist>> handlerPlaylistsNotFoundException (Exception exception, WebRequest request){
        ArrayList<Playlist> playlists = new ArrayList<>();
        return new ResponseEntity<>(playlists, HttpStatus.NO_CONTENT);
    }

}
