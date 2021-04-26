package com.shopapp.booksservice.exception;

public class ElementNotFoundException extends RuntimeException{

    public ElementNotFoundException(String message) {
        super(message);
    }
}

