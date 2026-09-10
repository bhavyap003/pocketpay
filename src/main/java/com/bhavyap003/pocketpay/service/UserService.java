package com.bhavyap003.pocketpay.service;

import com.bhavyap003.pocketpay.dto.UserResponse;
import com.bhavyap003.pocketpay.exception.EmailAlreadyExistsException;
import com.bhavyap003.pocketpay.exception.UserNotFoundException;
import com.bhavyap003.pocketpay.model.User;
import com.bhavyap003.pocketpay.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public UserResponse createUser(String name, String email, String password){
        if(userRepository.existsByEmail(email)){
            throw new EmailAlreadyExistsException("Email already exists");
        }

        String encodedPassword = passwordEncoder.encode(password);
        User user = new User(name, email, encodedPassword);
        user = userRepository.save(user);

        return new UserResponse(user.getId(), user.getName());
    }

    public UserResponse getUser(Long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found"));

        return new UserResponse(user.getId(), user.getName());
    }

}
