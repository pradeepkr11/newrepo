package com.myproject.javareceipt.exception;

public class NoOrderForVendorException extends RuntimeException{
    public NoOrderForVendorException(String msg){
        super(msg);
    }
}
