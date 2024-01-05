package com.vpereira.product.controllers;

import com.vpereira.product.core.domain.Product;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductController {
    public ResponseEntity<Product> create(Product product);
    public  ResponseEntity<Product> update(Product product, UUID id);
    public void delete(UUID id);
    public ResponseEntity<Optional<Product>> findById(UUID id);
    public ResponseEntity<List<Product>> findAll();
}
