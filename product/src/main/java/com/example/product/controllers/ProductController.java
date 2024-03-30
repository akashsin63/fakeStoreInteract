package com.example.product.controllers;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Product;
import com.example.product.services.IProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private IProductService productService;
    
    
    @GetMapping("/products")
    public List<Product> getAllProducts(){
         //The controller's responsibility is to retrun the product with name A 
    	List<Product> allProducts = productService.getAllProducts();
    	ArrayList<Product> filteredProducts = new ArrayList<>();
    	for(Product product : allProducts) {
    		if(product.getName().startsWith("a"))
            {
                filteredProducts.add(product);
            }
    	}
    	
    	if(filteredProducts.isEmpty()) {
            // If no products with names starting with "a" are found,
            // return all products instead
            return allProducts;
        } else {
            return filteredProducts;
        }
    	
    }

    //get product with id
    @GetMapping("/products/{id}")
    public Product getSingleProduct(@PathVariable("id") Long id){
    	//I should pass this id to fakeStoreAPI and get the details of product
    	//"https://fakestoreapi.com/products/1" 
    	
    	return productService.getSingleProduct(id);
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

        return productService.updateProduct(id,productRequestDto);
    }

    //delete the product
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return true;
    }
}
