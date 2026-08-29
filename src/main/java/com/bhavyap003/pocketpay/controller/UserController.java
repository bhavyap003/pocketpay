package com.bhavyap003.pocketpay.controller;

import com.bhavyap003.pocketpay.dto.CreateUserRequest;
import com.bhavyap003.pocketpay.dto.UserResponse;
import com.bhavyap003.pocketpay.model.User;
import com.bhavyap003.pocketpay.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @PostMapping
    public UserResponse createUser(@RequestBody CreateUserRequest request){
        return userService.createUser(request.getName(), request.getEmail());
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Long id){
        return userService.getUser(id);
    }
}
