package com.example.server.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class Product {
    String id;
    String name;
    String thumbnail;
    String explanation;
    int price;
}