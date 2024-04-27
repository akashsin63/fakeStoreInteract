package com.example.product.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import com.example.product.models.Product;


@Repository

public interface ProductRepository extends JpaRepository<Product, Long>{
	
	
	public Optional<Product> findByName(String name);
	public Optional<Product> findById(int id);
	public Optional<Product> findByNameAndDescriptionAndPriceGreaterThan(String title , String description,Double price);

}
