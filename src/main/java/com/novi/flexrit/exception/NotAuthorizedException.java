package com.novi.flexrit.exception;


public class NotAuthorizedException extends BadRequestException {

    private static final long serialVersionUID = 1L;

    public NotAuthorizedException(String message) {
        super(message);
    }
}