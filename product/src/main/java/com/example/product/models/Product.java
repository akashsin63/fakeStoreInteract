package com.example.product.models;



import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Product {
    private  Long id;
    private  String name;
    private String description;
    private int price;
    private String image;
    private com.example.product.models.Category category; 
	
}
