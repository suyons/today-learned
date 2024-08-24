package com.packt.cardatabase.domain;

import java.util.ArrayList;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Products {
    ArrayList<Product> products;

    public Products(Iterable<Product> productsIterator) {
        this.products = new ArrayList<Product>();
        productsIterator.forEach(product -> products.add(product));
    }
}
