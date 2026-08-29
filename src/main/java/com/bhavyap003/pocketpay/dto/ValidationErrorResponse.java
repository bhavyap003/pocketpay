package com.bhavyap003.pocketpay.dto;

import java.util.Map;

public class ValidationErrorResponse {

    private int status;
    private Map<String, String> errors;

    public ValidationErrorResponse(int status, Map<String, String> errors){
        this.status = status;
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

}
