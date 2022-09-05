package com.ciandt.summit.bootcamp2022.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid playlist")
public class PlaylistNotFoundException extends RuntimeException{
    private static final String MSG = "Playlist was not found";

    public PlaylistNotFoundException() {
        super(MSG);
    }
}
