package com.example.product.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import com.example.product.dtos.ProductRequestDto;
import com.example.product.dtos.ProductResponseDto;
import com.example.product.models.Category;
import com.example.product.models.Product;

@Service
@Primary
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
	 public Product getSingleProduct(Long id) throws InvalidProductIdException {

	        if(id>20){
	            throw new InvalidProductIdException("");
	        }

	        // I should pass this 'id' to fakestore and get the details of this product.
	        // "https://fakestoreapi.com/products/1"
	        ProductResponseDto response = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
	                ProductResponseDto.class);

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
    
    public Product addProduct(ProductRequestDto productReqeustDto) {
    	ResponseEntity<ProductResponseDto> responseEntity =  restTemplate
    			.postForEntity("https://fakestoreapi.com/products", productReqeustDto, ProductResponseDto.class);
    
    	// Check if the request was successful (HTTP status 2xx)
        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            // Convert the response DTO to your domain model (Product)
            ProductResponseDto productResponseDto = responseEntity.getBody();
            return getProductFromResponseDto(productResponseDto); // Assuming you have a method to convert DTO to domain object
        } else {
            // Handle error scenarios, e.g., throw an exception or return null
            // You might want to add more detailed error handling here
            throw new RuntimeException("Failed to add product. HTTP status: " + responseEntity.getStatusCodeValue());
        }
    }
    
    
    public boolean deleteProduct(Long id) {
    	 
    	String deleteUrl = "https://fakestoreapi.com/products"+id ;
    	
    	try {
    		restTemplate.delete(deleteUrl);
    		return true;
    	}
    	catch (HttpClientErrorException.NotFound e) {
            // If the product with the given ID is not found
            return false;
        }
    	
    }

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Long id, Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
