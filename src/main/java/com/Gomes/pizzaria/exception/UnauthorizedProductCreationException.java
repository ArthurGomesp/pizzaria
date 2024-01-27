package com.Gomes.pizzaria.exception;

public class UnauthorizedProductCreationException extends RuntimeException{
    public UnauthorizedProductCreationException(String message) {
        super(message);
    }
}
