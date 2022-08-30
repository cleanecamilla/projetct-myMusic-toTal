package com.ciandt.summit.bootcamp2022.controller.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.HashSet;
import java.util.Set;

@RestControllerAdvice
public class ExceptionHandlerControllerAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ExceptionResponseMessage onConstraintValidationException(ConstraintViolationException e) {
        Set<Violation> violations = new HashSet<>();

        for (ConstraintViolation v : e.getConstraintViolations()) {
            violations.add(new Violation(
                    removeMethodName(v.getPropertyPath().toString()),
                    v.getMessageTemplate()
            ));

        }

        return ExceptionResponseMessage.of(HttpStatus.BAD_REQUEST, violations);
    }

    private String removeMethodName(String source) {
        return source.substring(
                source.indexOf(".") + 1
        );
    }

}
