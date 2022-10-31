package com.cars.car.id.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDetail {
    private String error;
    private String desc;
}
