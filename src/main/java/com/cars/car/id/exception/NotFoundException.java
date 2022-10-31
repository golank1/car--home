package com.cars.car.id.exception;

public class NotFoundException extends Exception{
    public NotFoundException(){

    }
    public NotFoundException(String massage){
        super(massage);
    }
}
