package com.example.product.models;

import java.util.Date;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;


@MappedSuperclass   //basically if we use mapped superclass it wouldn't create new  table. but it will create table only to its subclasses
public class BaseModel {
	
	@Id
	private  Long id;
	private Date createdAt;
	private Date updatedAt;
}
