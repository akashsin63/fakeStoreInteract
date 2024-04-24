package com.example.product.dtos;

import com.example.product.models.BaseModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDto 
{
    private Long id;
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;
}
