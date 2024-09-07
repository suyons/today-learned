package com.example.server.controller;

import java.util.Optional;

import com.example.server.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.server.model.Product;
import com.example.server.repository.ProductRepository;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @Autowired
    private ProductService service;

    @GetMapping("")
    public Iterable<Product> getRoot() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable String id) {
        return repository.findById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable String id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable String id, @RequestParam String name,
            @RequestParam Long price, @RequestParam String explanation,
            @RequestParam(required = false) MultipartFile thumbnail) {
        service.updateProduct(id, name, price, explanation, thumbnail);
        return ResponseEntity.noContent().build();
    }
}
