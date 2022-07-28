package com.ciandt.summit.bootcamp2022.common.exception.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MusicsAndArtistsNotFoundException extends RuntimeException {

    public MusicsAndArtistsNotFoundException(String message) {
        super(message);
    }

}
