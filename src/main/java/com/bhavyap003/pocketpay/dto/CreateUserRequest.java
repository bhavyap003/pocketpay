package com.bhavyap003.pocketpay.dto;

public class CreateUserRequest {

    private String name;
    private String email;

    public CreateUserRequest(String name, String email){
        this.name = name;
        this.email = email;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }
}
