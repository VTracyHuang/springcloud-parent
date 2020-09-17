package com.example.demo.exception;

public class AuthFailedException extends RuntimeException {

    private static final long serialVersionUID = -5736463869541898945L;

    public AuthFailedException(String message) {
        super(message);
    }
}
