package com.example.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Category;
import com.example.product.models.Product;

@Service
public class FakeStoreProductService implements IProductService{
	
	@Autowired
	RestTemplate restTemplate;
	
	public Product getProductFromResponseDto(ProductResponseDto responseDto) {
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
    	
    	
    	ProductResponseDto response = restTemplate
    	.getForObject("https://fakestoreapi.com/products/"+id, ProductResponseDto.class);
    	
    	return getProductFromResponseDto(response);
    }
    
    @Override
	public List<Product> getAllProducts() {
		ProductResponseDto[] responseDtoList =
                restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDto[].class);

        List<Product> output = new ArrayList<>();
        for(ProductResponseDto productResponseDto: responseDtoList){
            output.add(getProductFromResponseDto(productResponseDto));
        }
        return output;
	}
    
    public Product updateProduct(Long id , ProductRequestDto productRequestDto) {
    	RequestCallback requestCallback = restTemplate
    			.httpEntityCallback(productRequestDto, ProductResponseDto.class);
    	
    	HttpMessageConverterExtractor<ProductResponseDto> responseExtractor =
                new HttpMessageConverterExtractor<>(ProductResponseDto.class,
                        restTemplate.getMessageConverters());
    	
    	 ProductResponseDto responseDto = restTemplate.execute("https://fakestoreapi.com/products/" + id,
                 HttpMethod.PUT, requestCallback, responseExtractor);
    	 return getProductFromResponseDto(responseDto);
    	
    	
    }

	
}
