package com.web.demo.async.services;

import com.web.demo.async.dto.Product;
import com.web.demo.async.dto.Products;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> getAllProducts();

    Mono<Products> getProductById(int id);

    Mono<ResponseEntity<Void>> saveProduct(Products products);
}
