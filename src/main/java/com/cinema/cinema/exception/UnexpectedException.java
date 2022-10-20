package com.cinema.cinema.exception;

public class UnexpectedException extends RuntimeException{

    String message;
    String fieldName;
    String fieldValue;

    public UnexpectedException(String message, String fieldName, String fieldValue) {
        super(String.format(message, fieldName, fieldValue));
        this.message = message;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }
}
