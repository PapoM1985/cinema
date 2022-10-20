package com.cinema.cinema.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(UnexpectedException.class)
    public ResponseEntity<String> ResourceNotFoundExceptionHandler(UnexpectedException  ex ){
        String message = ex.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.OK);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<String> ResourceNotFoundExceptionHandler(ResourceNotFoundException  ex ){
        String message = ex.getMessage();
        return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
    }
}
