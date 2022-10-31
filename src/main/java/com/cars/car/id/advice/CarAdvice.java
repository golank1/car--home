package com.cars.car.id.advice;

import com.cars.car.id.exception.NotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@ControllerAdvice

public class CarAdvice {
    @ExceptionHandler(value = {JsonProcessingException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetail invalidJSON (Exception err){
        return new ErrorDetail("Bad JSON", err.getMessage());
    }

    @ExceptionHandler(value = {NotFoundException.class})
    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    public ErrorDetail notFound(Exception err){
        return new ErrorDetail("Bed Number", err.getMessage());
    }
}
