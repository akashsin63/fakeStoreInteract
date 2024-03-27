package com.example.product.services;

import org.springframework.stereotype.Service;

import com.example.product.models.Product;

@Service
public class FakeStoreProductService implements IProductService{

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }
}
