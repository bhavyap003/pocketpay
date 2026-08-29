package com.bhavyap003.pocketpay.service;

import com.bhavyap003.pocketpay.dto.GreetingResponse;
import com.bhavyap003.pocketpay.model.User;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    public GreetingResponse getGreeting() {

        User user = new User("Bhavya", "bhavya@example.com");

        return new GreetingResponse("Hello " + user.getName() + ", welcome to PocketPay!");
    }

}
