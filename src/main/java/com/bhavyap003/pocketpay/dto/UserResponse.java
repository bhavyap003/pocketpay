package com.bhavyap003.pocketpay.dto;

public class UserResponse {

    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public UserResponse(Long id, String name){
        this.id = id;
        this.name = name;
    }
}
