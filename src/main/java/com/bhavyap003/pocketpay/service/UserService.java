package com.bhavyap003.pocketpay.service;

import com.bhavyap003.pocketpay.dto.UserResponse;
import com.bhavyap003.pocketpay.exception.UserNotFoundException;
import com.bhavyap003.pocketpay.model.User;
import com.bhavyap003.pocketpay.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public UserResponse createUser(String name, String email){
        User user = new User(name, email);
        user = userRepository.save(user);

        return new UserResponse(user.getId(), user.getName());
    }

    public UserResponse getUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return new UserResponse(user.getId(), user.getName());
    }

}
