package com.example.exception;

public class BaseExcepciton extends RuntimeException {
    private final ErrorMessage errorMessage;
    public BaseExcepciton(ErrorMessage errorMessage) {
        super(errorMessage.preapareMessage());
        this.errorMessage = errorMessage;
    }
}
