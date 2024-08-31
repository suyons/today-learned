package com.example.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.model.User;
import com.example.server.service.JwtService;
import com.example.server.repository.UserRepository;

@RestController
public class JoinController {
    @Autowired
    UserRepository repository;

    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    @PostMapping("/join")
    public ResponseEntity<?> postUser(@RequestBody User user) {
        String password_encoded = encoder.encode(user.getPassword());
        user.setPassword(password_encoded);
        
        repository.save(user);

        // Build response with the generated token
        return ResponseEntity.ok("회원가입 성공");
    }
}
