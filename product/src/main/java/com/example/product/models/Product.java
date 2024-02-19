package com.example.product.models;

import jdk.jfr.Category;
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
    private Category category;
}
