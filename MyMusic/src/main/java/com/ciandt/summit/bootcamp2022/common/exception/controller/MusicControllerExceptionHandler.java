package com.ciandt.summit.bootcamp2022.common.exception.controller;

import com.ciandt.summit.bootcamp2022.common.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class MusicControllerExceptionHandler {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ConstraintViolationException> FilterLengthException() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("The filter must contain at least 2 characters.");
        return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
    }

}
