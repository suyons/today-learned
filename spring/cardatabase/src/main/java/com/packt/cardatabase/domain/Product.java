package com.packt.cardatabase.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name, explanation, thumbnail;
    private Long price;

    @Column(nullable = true)
    private Long discount;

    public Product() {
    }

    public Product(String name, String explanation, String thumbnail, Long price, Long discount) {
        this.name = name;
        this.explanation = explanation;
        this.thumbnail = thumbnail;
        this.price = price;
        this.discount = discount;
    }
}
