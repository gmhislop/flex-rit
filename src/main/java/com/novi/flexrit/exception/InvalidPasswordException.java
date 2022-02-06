package com.novi.flexrit.exception;


public class InvalidPasswordException extends BadRequestException {
    private static final long serialVersionUID = 1L;

    public InvalidPasswordException(String message) {
        super(message);
    }
}