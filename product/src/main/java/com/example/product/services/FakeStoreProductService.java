package com.example.product.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Category;
import com.example.product.models.Product;

@Service
public class FakeStoreProductService implements IProductService{
	
	public Product getProductResponseDto(ProductResponseDto responseDto) {
		Product product = new Product();
        product.setId(responseDto.getId());
        product.setName(responseDto.getTitle());
        product.setPrice(responseDto.getPrice());
        product.setDescription(responseDto.getDescription());
        product.setImage(responseDto.getImage());

        Category category = new Category();
        category.setName(responseDto.getCategory());

        product.setCategory(new Category());
        return product;
	}

    @Override
    public Product getSingleProduct(Long id) {
    	RestTemplate restTemplate = new RestTemplate();
    	
    	ProductResponseDto response = restTemplate
    	.getForObject("https://fakestoreapi.com/products/"+id, ProductResponseDto.class);
    	
    	return getProductResponseDto(response);
    }
}
