package com.bhavyap003.pocketpay.controller;

import com.bhavyap003.pocketpay.dto.GreetingResponse;
import com.bhavyap003.pocketpay.service.GreetingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StartController {

    private final GreetingService greetingService;

    public StartController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/hello")
    public GreetingResponse hello(){
        return greetingService.getGreeting();
    }
}
