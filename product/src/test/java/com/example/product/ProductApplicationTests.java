package com.example.product;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;

@SpringBootTest
class ProductApplicationTests {
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Test
	void contextLoads() {
	}
	
	public void getSomeData() {
		Optional<Product> productOptional = productRepository.findByName("MacBook");
		
		if(productOptional.isEmpty()) {
			return;
		}
		Product product = productOptional.get();
		System.out.println(product.getId() + " " + product.getPrice());
	}
}
