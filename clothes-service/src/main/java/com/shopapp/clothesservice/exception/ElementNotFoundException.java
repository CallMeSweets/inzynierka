package com.shopapp.clothesservice.exception;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String message) {
        super(message);
    }
}

