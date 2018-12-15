package com.example.security.exception;

public class UserAlreadyExistsException extends RuntimeException{
    @Override
    public String getMessage() {
        return "The user already exists.";
    }
}
