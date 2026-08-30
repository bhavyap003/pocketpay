package com.bhavyap003.pocketpay.model;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Column(unique = true)
    private String email;

    protected User(){

    }

    public User(String name, String email){
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

