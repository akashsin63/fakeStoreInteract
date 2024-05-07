package com.example.product.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.product.models.Category;

public interface CategoryRepository extends JpaRepository<Category , Long>{
	Category save(Category category);
	Optional<Category> findByName(String name);

}
