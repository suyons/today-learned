package com.example.server.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.example.server.model.Product;
import com.example.server.model.ProductArray;
import com.google.gson.Gson;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductService {
    public ProductArray loadProducts() {
        Gson gson = new Gson();
        ClassPathResource resource = new ClassPathResource("products.json");
        BufferedReader br;
        StringBuilder sb = new StringBuilder();
        String s = "";
        try {
            br = new BufferedReader(new InputStreamReader(resource.getInputStream()));
            while ((s = br.readLine()) != null) {
                sb.append(s);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        ProductArray products = gson.fromJson(sb.toString(), ProductArray.class);
        return products;
    }
}
