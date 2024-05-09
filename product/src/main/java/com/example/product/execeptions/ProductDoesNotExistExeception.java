package com.example.product.execeptions;

public class ProductDoesNotExistExeception extends Exception {
	public ProductDoesNotExistExeception(String message) {
		super(message);
	}
}
