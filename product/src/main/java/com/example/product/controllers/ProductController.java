package com.example.product.controllers;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Product;
import org.springframework.web.bind.annotation.*;

import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return new ArrayList<>();
    }

    //get product with id
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
        return new Product();

    }
    //add product
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
        return new Product();
    }
    //update the existing product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,
                                 @RequestBody ProductRequestDto productRequestDto){

        return new Product();
    }

    //delete the product
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }
}
