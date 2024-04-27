package com.example.product.models;

import java.util.Date;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.*;

@Getter
@Setter
@MappedSuperclass   //basically if we use mapped superclass it wouldn't create new  table. but it will create table only to its subclasses
public class BaseModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	private Date createdAt;
	private Date updatedAt;
}
