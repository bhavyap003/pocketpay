package com.bhavyap003.pocketpay.controller;

import com.bhavyap003.pocketpay.dto.ErrorResponse;
import com.bhavyap003.pocketpay.dto.LoginRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;

    public AuthController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }


    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest request){

        try{
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    request.getEmail(),
                    request.getPassword());

            authenticationManager.authenticate(authenticationToken);

            return ResponseEntity.ok("Login successful");
        } catch(AuthenticationException ex){

            ErrorResponse error = new ErrorResponse(HttpStatus.UNAUTHORIZED.value(),
                    "Invalid email or password");

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(error);
        }
    }

}
