package com.ciandt.summit.bootcamp2022.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(
        value = HttpStatus.BAD_REQUEST,
        reason = too_short: "The user name must have at least %{count} characters"Minimum s")
public class MinimumFilterLenghtException extends RuntimeException{
}
