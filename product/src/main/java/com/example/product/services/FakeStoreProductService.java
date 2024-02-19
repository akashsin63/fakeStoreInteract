package com.example.product.services;

import com.example.product.models.Product;

public class FakeStoreProductService implements IProductService{

    @Override
    public Product getSingleProduct(Long id) {
        return null;
    }
}
