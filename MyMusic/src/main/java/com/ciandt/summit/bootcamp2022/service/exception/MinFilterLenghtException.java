package com.ciandt.summit.bootcamp2022.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = "The filter must have at least 3 characters")
public class MinFilterLenghtException extends RuntimeException {}
