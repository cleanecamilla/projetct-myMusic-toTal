package com.ciandt.summit.bootcamp2022.controller.advice;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import java.time.Instant;
import java.util.Set;


@Getter
public class ValidationErrorResponse {
    private Instant time;
    private int status;
    private String error;
    private Set<Violation> violations;

    private ValidationErrorResponse(int status,
                                     Set<Violation> violations){
        this.time = Instant.now();
        this.status = status;
        this.violations = violations;
    }


    static ValidationErrorResponse of(HttpStatus status,
                                       Set<Violation> v){
        return new ValidationErrorResponse(
                status.value(),
                v);
    }
}
