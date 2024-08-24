package com.example.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<String> getRoot() {
        return ResponseEntity.ok().body("GET /");
    }

}
