package com.example.server.repository;

import java.util.List;

import com.example.server.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, String> {
    List<Product> findByName(@Param("name") String name);
}
