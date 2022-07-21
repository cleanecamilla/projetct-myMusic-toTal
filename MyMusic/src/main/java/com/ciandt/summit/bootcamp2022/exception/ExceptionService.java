package com.ciandt.summit.bootcamp2022.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionService {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionService.class);

    @ExceptionHandler(FiltroInvalidoException.class)
    ResponseEntity<FiltroInvalidoException> handleException(FiltroInvalidoException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.BAD_REQUEST.value());
        uer.setMessage("O filtro utilizado na busca ("+err.getMessage()+") tem menos de 3 caracteres.");
        logger.error(uer.getMessage() + " - " + HttpStatus.BAD_REQUEST);
        return new ResponseEntity(uer,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MusicaNaoEncontradaException.class)
    ResponseEntity<MusicaNaoEncontradaException> handleException(MusicaNaoEncontradaException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.NO_CONTENT.value());
        uer.setMessage("A busca realizada não retornou nenhum resultado!");
        logger.error(uer.getMessage() + " - " + HttpStatus.NO_CONTENT);
        return new ResponseEntity(uer,HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler(UsuarioNaoAutorizadoException.class)
    ResponseEntity<UserErrorResponse> handleException(UsuarioNaoAutorizadoException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.FORBIDDEN.value());
        uer.setMessage(err.getMessage());
        logger.error(uer.getMessage() + " - " + HttpStatus.FORBIDDEN);
        return new ResponseEntity(uer,HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(NaoPermitidoSalvarAMesmaMusicaException.class)
    ResponseEntity<UserErrorResponse> handleException(NaoPermitidoSalvarAMesmaMusicaException err){
        UserErrorResponse uer =new UserErrorResponse();
        uer.setStatus(HttpStatus.FORBIDDEN.value());
        uer.setMessage("Não é permitido salvar a mesma música duas vezes.");
        logger.error(uer.getMessage() + " - " + HttpStatus.FORBIDDEN);
        return new ResponseEntity(uer,HttpStatus.FORBIDDEN);
    }
}
