package com.example.product.models;



import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel {
	
    
    private  String name;
    private String description;
    private int price;
    private String image;
    
    //every product will have only one cateogry 
    //but every category will have multiple product 
    
    @ManyToOne
    private com.example.product.models.Category category; 
	
}
