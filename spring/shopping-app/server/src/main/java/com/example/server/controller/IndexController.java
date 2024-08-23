package com.example.server.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class IndexController {
    @GetMapping("/")
    public ResponseEntity<String> getRoot() {
        return ResponseEntity.ok().body("Shopping App API server");
    }
}

