package com.cars.car.id.controller;

import com.cars.car.id.exception.NotFoundException;
import com.cars.car.id.services.CarServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor

public class CarController {
    private final CarServices carServices;

    @GetMapping("/car/{number}")
    public ResponseEntity<?> getByCarNumber(@PathVariable long number) throws NotFoundException, JsonProcessingException {
        return new ResponseEntity<>(carServices.getByPlateId(number), HttpStatus.OK);
    }

}
