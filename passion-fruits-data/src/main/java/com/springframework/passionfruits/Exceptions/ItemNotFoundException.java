package com.springframework.passionfruits.Exceptions;

public class ItemNotFoundException extends RuntimeException{
	
	public ItemNotFoundException() {
		super();
	}
	public ItemNotFoundException(String message) {
		super(message);
	}
	
}
