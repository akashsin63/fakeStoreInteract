package com.example.product.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Category {
    private Long id;
    private String name;
}
