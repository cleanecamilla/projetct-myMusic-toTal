package com.ciandt.summit.bootcamp2022.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidParameterException extends RuntimeException {
    public InvalidParameterException(String message) {
        super(message);
    }
    /*exemplo de implementação da exceção
     * na controller, quando o parametro for invalido, lançar throw new InvalidParameterException("Busca deve conter pelo menos 2 caracteres") */
}
