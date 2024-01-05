package com.vpereira.product.controllers;

import com.vpereira.product.core.domain.Product;
import com.vpereira.product.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/product")
public class ProductControllerImp implements ProductController{

    @Autowired
    ProductService productService;

    @PostMapping
    @Override
    public ResponseEntity<Product> create(@RequestBody Product product) {
        return productService.create(product);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Product> update(@RequestBody Product product, @PathVariable(name = "id") UUID id) {
        return productService.update(product, id);
    }

    @DeleteMapping("/{id}")
    @Override
    public void delete(@PathVariable(name = "id") UUID id) {
         productService.delete(id);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<Optional<Product>> findById(@PathVariable(name = "id")UUID id) {
        return productService.findById(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<Product>> findAll() {
        return productService.findAll();
    }
}
