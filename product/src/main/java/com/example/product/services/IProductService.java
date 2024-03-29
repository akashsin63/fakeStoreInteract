package com.example.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.models.Product;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id);
    public List<Product> getAllProduct();
}
