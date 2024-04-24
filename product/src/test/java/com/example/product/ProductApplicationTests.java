package com.example.product;

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
		Product product = productRepository.findByName("MacBook");
		
		System.out.println(product.getName() + " " + product.getPrice());
	}
}
