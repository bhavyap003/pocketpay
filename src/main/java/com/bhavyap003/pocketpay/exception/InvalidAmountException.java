package com.bhavyap003.pocketpay.exception;

public class InvalidAmountException extends RuntimeException{

    public InvalidAmountException(String message){
        super(message);
    }
}
