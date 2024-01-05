package com.vpereira.product.services;

import com.vpereira.product.core.domain.Product;
import com.vpereira.product.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductServiceImp implements ProductService{
    
    @Autowired
    ProductRepository productRepository;

    @Override
    public ResponseEntity<Product> create(Product product) {
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @Override
    public ResponseEntity<Product> update(Product product, UUID id) {
        Optional<Product> productEntity = productRepository.findById(id);
        if(productEntity.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
        }
        product.setId(id);
        productRepository.save(product);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public ResponseEntity<Optional<Product>> findById(UUID id) {
        Optional<Product> product = productRepository.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @Override
    public ResponseEntity<List<Product>> findAll() {
        List<Product> product = productRepository.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

}
