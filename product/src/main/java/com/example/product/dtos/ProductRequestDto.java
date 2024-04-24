package com.example.product.dtos;

import com.example.product.models.BaseModel;

import lombok.*;

@Getter
@Setter
public class ProductRequestDto extends BaseModel {
    private String title;
    private int price;
    private String description;
    private String image;
    private String category;
}
