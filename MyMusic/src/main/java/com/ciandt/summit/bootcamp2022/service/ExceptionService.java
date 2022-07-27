package com.ciandt.summit.bootcamp2022.service;

import com.ciandt.summit.bootcamp2022.exception.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ExceptionService {
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ConstraintViolationException> FilterLengthException() {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage("The filter must contain more than 1 character.");
        return new ResponseEntity(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
