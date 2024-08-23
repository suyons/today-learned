package com.example.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/search")
public class SearchController {
    @GetMapping("")
    public String getRoot(@RequestParam String param) {
        return new String();
    }
}
