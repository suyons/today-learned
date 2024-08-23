package com.example.server.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.server.model.Product;
import com.example.server.service.ProductService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;

    @GetMapping(value = "", produces = "application/json")
    public ResponseEntity<Product[]> getRoot() {
        return ResponseEntity.ok().body(productService.loadProducts());
    }

    @PostMapping("")
    public String postRoot() {
        return new String();
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable String id) {
        return new String();
    }

    @PatchMapping("/{id}")
    public String patchById(@PathVariable String id) {
        return new String();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable String id) {
        return new String();
    }
}
