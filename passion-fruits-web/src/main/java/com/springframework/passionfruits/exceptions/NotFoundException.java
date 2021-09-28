package com.springframework.passionfruits.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{
	public NotFoundException() {
		super();
	}
	
	public NotFoundException(String message) {
		super(message);
	}
	 
	public NotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
