package com.example.beerstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BearAlreadyRegisteredException extends Exception {

    public BearAlreadyRegisteredException(String name) {

        super(String.format("Beer %s is already registered",name));
    }
}
