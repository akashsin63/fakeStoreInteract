package com.example.product.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.product.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
	
//	@Query("")
//	public <optional>Product findByName(String name) {
//		
//	}
//	public <optional>Product findById(int id) {
//		
//	}
//	public <optional>Product findByNameAndDiscriptionAndPriceGreaterThan(Stirng title , String discription,Double price){
//		
//	}

}
