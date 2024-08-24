package com.packt.cardatabase.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.Product;
import com.packt.cardatabase.domain.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    /*
     * @GetMapping("")
     * public Products getRoot() {
     * Products products = new Products(repository.findAll());
     * return products;
     * }
     */

    @GetMapping("")
    public Iterable<Product> getRoot() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getById(@PathVariable String id) {
        return repository.findById(id);
    }

}
