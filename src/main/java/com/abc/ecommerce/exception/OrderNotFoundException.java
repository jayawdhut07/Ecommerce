package com.abc.ecommerce.exception;

public class OrderNotFoundException extends RuntimeException{
	
	public OrderNotFoundException(String msg) { 
		super(msg);
	}
	
} 
