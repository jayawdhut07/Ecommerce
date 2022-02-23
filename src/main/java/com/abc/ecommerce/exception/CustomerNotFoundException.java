package com.abc.ecommerce.exception;

public class CustomerNotFoundException extends RuntimeException{

	public CustomerNotFoundException(String msg) {
		super(msg);
	}
}
