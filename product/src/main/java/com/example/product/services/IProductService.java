package com.example.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Product;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id);
    public List<Product> getAllProducts();
    public Product updateProduct(Long id ,ProductRequestDto productRequestDto);
}
