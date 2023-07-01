package com.web.demo.async.services;

import com.web.demo.async.client.ProductClientService;
import com.web.demo.async.dto.Product;
import com.web.demo.async.dto.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductClientService productClientService;

    @Autowired
    public void setProductClientService(ProductClientService productClientService) {
        this.productClientService = productClientService;
    }

    @Override
    public Flux<Product> getAllProducts() {
        return productClientService.getAllProducts();
    }

    @Override
    public Mono<Products> getProductById(int id) {
        return productClientService.getProductById(id);
    }

    @Override
    public Mono<ResponseEntity<Void>> saveProduct(Products products) {
        return productClientService.saveProduct(products);
    }
}
