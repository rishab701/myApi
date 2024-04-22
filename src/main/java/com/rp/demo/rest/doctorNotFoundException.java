package com.rp.demo.rest;

public class doctorNotFoundException extends RuntimeException{


    public doctorNotFoundException(Throwable cause) {
        super(cause);
    }

    public doctorNotFoundException(String message) {
        super(message);
    }

    public doctorNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
