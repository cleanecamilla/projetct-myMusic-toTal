package com.ciandt.summit.bootcamp2022.controller.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Violation {
    private String fieldName;
    private String violation;

}
