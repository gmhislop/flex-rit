package com.novi.flexrit.exception;

public class UserNotFoundException extends BadRequestException {
    private static final long serialVersionUID = 1L;

    public UserNotFoundException(String message) {
        super(message);
    }


}
