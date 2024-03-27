package com.example.product.services;

import org.springframework.stereotype.Service;

import com.example.product.models.Product;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id);
}
