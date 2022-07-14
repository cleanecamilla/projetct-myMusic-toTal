package com.ciandt.summit.bootcamp2022.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    @ExceptionHandler(FiltroInvalidoException.class)
    ResponseEntity<FiltroInvalidoException> handleException(FiltroInvalidoException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage("O filtro utilizado na busca ("+err.getMessage()+") tem menos de 3 caracteres.");
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MusicaNaoEncontradaException.class)
    ResponseEntity<MusicaNaoEncontradaException> handleException(MusicaNaoEncontradaException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NO_CONTENT.value());
        uer.setMessage("A busca realizada não retornou nenhum resultado!");
        return new ResponseEntity(uer,HttpStatus.NO_CONTENT);
    }

}
