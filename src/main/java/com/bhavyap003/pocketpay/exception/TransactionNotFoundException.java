package com.bhavyap003.pocketpay.exception;

public class TransactionNotFoundException extends RuntimeException{

    public TransactionNotFoundException(String message){
        super(message);
    }

}
