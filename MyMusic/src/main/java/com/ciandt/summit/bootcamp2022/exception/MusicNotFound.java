package com.ciandt.summit.bootcamp2022.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.NO_CONTENT,
        reason = "Music not found")
public class MusicNotFound extends RuntimeException{}
