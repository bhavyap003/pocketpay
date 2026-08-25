package com.bhavyap003.pocketpay.service;

import com.bhavyap003.pocketpay.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    public User createUser(String name, String email){
        return new User(1L, name, email);
    }

}
