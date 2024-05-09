package com.example.product.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.execeptions.ProductDoesNotExistExeception;
import com.example.product.models.Product;

@Service
public interface IProductService {
    public Product getSingleProduct(Long id) throws InvalidProductIdException;
    public List<Product> getAllProducts();
    Product updateProduct(Long id, Product product) throws ProductDoesNotExistExeception;
    public Product addProduct(Product product);
    public boolean deleteProduct(Long id);
}
