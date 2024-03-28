package com.myproject.javareceipt.exception;

public class OrderNotFoundException extends RuntimeException{
    public OrderNotFoundException(String msg){
        super(msg);
    }
}
