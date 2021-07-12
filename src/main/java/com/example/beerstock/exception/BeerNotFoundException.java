package com.example.beerstock.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BeerNotFoundException extends Exception {

    public BeerNotFoundException(String name) {

        super(String.format("Beer with Name is %s not found in system.",name));
    }

    public BeerNotFoundException(Long id) {

        super(String.format("Beer with ID is %s not found in system.",id));
    }

}
