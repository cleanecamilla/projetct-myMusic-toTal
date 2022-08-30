package com.ciandt.summit.bootcamp2022.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Violation {

    private final String fieldName;
    private final String message;

}