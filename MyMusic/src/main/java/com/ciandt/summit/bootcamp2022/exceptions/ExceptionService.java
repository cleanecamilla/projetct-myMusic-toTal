package com.ciandt.summit.bootcamp2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler
    ResponseEntity<FiltroErrorException> handleException(FiltroErrorException err){
        MusicaErrorResponse user = new MusicaErrorResponse();
        user.setStatus(HttpStatus.BAD_REQUEST.value());
        user.setMessage("Numeros de caracteres invalidos!");
        return new ResponseEntity(user,HttpStatus.BAD_REQUEST);
    }
}
