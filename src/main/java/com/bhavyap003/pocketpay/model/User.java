package com.bhavyap003.pocketpay.model;

public class User {
    private Long id;
    private String name;
    private String email;

    public User(Long id, String name, String email){
        this.id = id;
        this.name = name;
        this.email = email;

    }

    public String getName(){
        return name;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }
}

