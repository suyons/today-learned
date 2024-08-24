package com.packt.cardatabase.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.packt.cardatabase.domain.ProductRepository;
import com.packt.cardatabase.domain.Products;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @GetMapping("")
    public Products getMethodName() {
        // return repository.findAll();
        Products products = new Products(repository.findAll());
        return products;
    }

}
