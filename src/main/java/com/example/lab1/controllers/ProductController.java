package com.example.lab1.controllers;

import com.example.lab1.dtos.Product;
import com.example.lab1.dtos.ProductItemDTO;
import com.example.lab1.orms.ProductORM;
import com.example.lab1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> getProduct(@PathVariable Long id) {
        Optional<ProductORM> optionalProductORM = productRepository.findById(id);

        if (optionalProductORM.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(new Product(optionalProductORM.get()));
    }

    @PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        System.out.println(product.toString());
        productRepository.save(new ProductORM(product));

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/product")
    public ResponseEntity<List<Product>> getProducts() {
        List<ProductORM> productORMList = (List<ProductORM>) productRepository.findAll();
        List<Product> products = productORMList.stream()
                .map(Product::new)
                .toList();

        if (products.isEmpty())
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(products);
    }

    @PostMapping("/product_item")
    public ResponseEntity<Void> createProductItem(@RequestBody ProductItemDTO productItemDTO) {
        productRepository.save(new ProductORM(productItemDTO));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
