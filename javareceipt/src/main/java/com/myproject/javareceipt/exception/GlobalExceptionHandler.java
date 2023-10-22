package com.myproject.javareceipt.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler
    public void handleAllException(Exception e){
        System.out.println("Exception");
        System.out.println(e.getMessage());
    }
}
