package com.usaToday.supermarket.service;


import com.usaToday.supermarket.model.Products;
import com.usaToday.supermarket.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    public List<Products> getAllProducts() {

        return productDao.findAll();

    }

    public Optional<Products> getProductById(UUID Product_id) {
        return productDao.findById(Product_id);
    }

    public Optional<List<Products>> getProductsBySection(String section) {
        return productDao.findBySection(section);
    }

    public Optional<List<Products>> getProductsInStock() {
        return productDao.findInStock();
    }

    public Products addProduct(Products product) {
        return productDao.save(product);
    }
}
