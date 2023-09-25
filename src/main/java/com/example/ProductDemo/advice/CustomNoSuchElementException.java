package com.example.ProductDemo.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomNoSuchElementException {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleCustomException(NoSuchElementException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Custom Exception: " + ex.getMessage());
    }

}
