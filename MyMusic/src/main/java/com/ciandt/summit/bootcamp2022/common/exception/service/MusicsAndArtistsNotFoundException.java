package com.ciandt.summit.bootcamp2022.common.exception.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NO_CONTENT)
public class MusicsAndArtistsNotFoundException extends RuntimeException {
}
