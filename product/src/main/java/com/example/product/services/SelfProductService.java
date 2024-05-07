package com.example.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Category;
import com.example.product.models.Product;
import com.example.product.repositories.CategoryRepository;
import com.example.product.repositories.ProductRepository;

@Service
@Primary
@Qualifier("selfProduct")
public class SelfProductService implements IProductService { 
	
	
	private ProductRepository productRepository;
	private CategoryRepository categoryRepository;
	
	
	
	@Autowired
	public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository= productRepository;
		this.categoryRepository = categoryRepository;
	}
	

	@Override
	public Product getSingleProduct(Long id) throws InvalidProductIdException {
		// TODO Auto-generated method stub
		Optional<Product> productOptional = productRepository.findById(id);
		
		if(productOptional.isEmpty()) {
			 throw new InvalidProductIdException("prdoduct with id : " +id + " not found");
		}
		
		Product product = productOptional.get();
		return product;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Long id, ProductRequestDto productRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product addProduct(Product product) {
		
		// TODO Auto-generated method stub
		Optional<Category> categoryOptional = categoryRepository.findByName(product.getCategory().getName());
		if(categoryOptional.isEmpty()) {
			Category categoryToSave = new Category();
			categoryToSave.setName(product.getCategory().getName());
			Category savedCategory = categoryRepository.save(categoryToSave);
			product.setCategory(savedCategory);
		}else{
			product.setCategory(categoryOptional.get());
		}
		Product savedProduct = productRepository.save(product);
		
		return savedProduct;
	}

	@Override
	public boolean deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
