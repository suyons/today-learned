package com.example.server.service;

import com.example.server.model.Product;
import com.example.server.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public void updateProduct(String id, Product params, MultipartFile thumbnail) {
        Optional<Product> optionalProduct = repository.findById(id);

        if (optionalProduct.isEmpty()) {
            System.out.println("일치하는 레코드가 없습니다.");
            return;
        }

        Product product = optionalProduct.get();

        if (params.getName() != null) {
            product.setName(params.getName());
        }

        if (params.getPrice() != null) {
            try {
                product.setPrice(params.getPrice());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

        if (params.getExplanation() != null) {
            product.setExplanation(params.getExplanation());
        }

        if (thumbnail != null && !thumbnail.isEmpty()) {
            String thumbnailPath = saveThumbnail(thumbnail);
            product.setThumbnail(thumbnailPath);
        }

        repository.save(product);
    }

    public String saveThumbnail(MultipartFile file) {
        try {
            Resource resource = new ClassPathResource("static/thumbnails");
            Path path = Paths.get(resource.getURI()).resolve(file.getOriginalFilename());

            Files.createDirectories(path.getParent());

            Files.write(path, file.getBytes());
            return "thumbnails/" + file.getOriginalFilename();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
