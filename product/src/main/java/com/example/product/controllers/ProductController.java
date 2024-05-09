package com.example.product.controllers;

import com.example.product.dtos.ErrorResponseDto;
import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.dtos.ProductWrapper;
import com.example.product.execeptions.ProductDoesNotExistExeception;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.services.IProductService;
import com.example.product.services.InvalidProductIdException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.awt.color.ProfileDataException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    
    private IProductService productService;
    
    @Autowired
    public ProductController(@Qualifier("selfProduct")IProductService productService) {
    	this.productService = productService;
    }
    
    
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
  
    public ResponseEntity<ProductWrapper> getSingleProduct(@PathVariable("id") Long id) throws InvalidProductIdException {

        ResponseEntity<ProductWrapper> response;
        Product singleProduct = productService.getSingleProduct(id);
        ProductWrapper productWrapper = new ProductWrapper(singleProduct, "Successfully retried the data");
        response = new ResponseEntity<>(productWrapper, HttpStatus.OK);
        return response;
    }
   
    
    //add product
    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDto productRequestDto){
    	Product product = new Product();
    	product.setName(productRequestDto.getTitle());
    	product.setDescription(productRequestDto.getDescription());
    	product.setPrice(productRequestDto.getPrice());
    	product.setImage(productRequestDto.getImage());
    	product.setCategory(new Category());
    	product.getCategory().setName(productRequestDto.getCategory());
    	
    	Product saveProduct = productService.addProduct(product);
        return saveProduct;
    }
    //update the existing product
    @PutMapping("/products/{id}")
    public Product updateProduct(@PathVariable("id") Long id,
                                 @RequestBody ProductRequestDto productRequestDto) throws ProductDoesNotExistExeception{
    	Product product = new Product();
    	product.setId(id);
    	product.setName(productRequestDto.getTitle());
    	product.setDescription(productRequestDto.getDescription());
    	product.setPrice(productRequestDto.getPrice());
    	product.setImage(productRequestDto.getImage());
    	product.setCategory(new Category());
    	product.getCategory().setName(productRequestDto.getCategory());
    	

        return productService.updateProduct(id,product);
    }

    //delete the product
    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable("id") Long id){
        return productService.deleteProduct(id);
    }
}
