package com.usaToday.supermarket.controller;


import com.usaToday.supermarket.model.Products;
import com.usaToday.supermarket.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController
{

    @Autowired
    private ProductService productService;


    @GetMapping("/allproducts")
    public ResponseEntity<List<Products>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/products/{Product_id}")
    public ResponseEntity<Optional<Products>> getProductById(@PathVariable UUID Product_id){
        return new ResponseEntity<>(productService.getProductById(Product_id), HttpStatus.OK);
    }

    @GetMapping("/products/productsBySection")
    public ResponseEntity<Optional<List<Products>>> getProductsBySection(@RequestParam String section){
        return new ResponseEntity<>(productService.getProductsBySection(section), HttpStatus.OK);
    }

    @GetMapping("/products/inStock")
    public ResponseEntity<Optional<List<Products>>> getProductsInStock(){
        return new ResponseEntity<>(productService.getProductsInStock(), HttpStatus.OK);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<?> addProduct(@RequestBody Products product) {
        Products savedProduct = null;
        savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);

    }

}
