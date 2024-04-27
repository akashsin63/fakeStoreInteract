package com.example.product.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.models.Product;
import com.example.product.repositories.ProductRepository;

@Service
@Primary
@Qualifier("selfProduct")
public class SelfProductService implements IProductService { 
	
	ProductRepository productRepository;
	
	public SelfProductService(ProductRepository productRepository) {
		this.productRepository= productRepository;
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
	public Product addProduct(ProductRequestDto productRequestDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteProduct(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
