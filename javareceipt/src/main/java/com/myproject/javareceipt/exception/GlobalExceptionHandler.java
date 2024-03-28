package com.myproject.javareceipt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoOrderForVendorException.class)
    public ResponseEntity<ErrorDetails> handleNoOrderForVendorException(NoOrderForVendorException e){
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OrderNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleOrderNotFoundException(OrderNotFoundException e){
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorDetails> handleAllException(Exception e){
        System.out.println("Exception occurred");
        System.out.println(e.getMessage());
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(errorDetails,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
