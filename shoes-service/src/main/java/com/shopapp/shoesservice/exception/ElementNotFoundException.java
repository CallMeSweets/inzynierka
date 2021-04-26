package com.shopapp.shoesservice.exception;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String message) {
        super(message);
    }
}

