package com.springframework.passionfruits.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler({NotFoundException.class})
	ResponseEntity<?> handelNotFoundException(Exception e, WebRequest request) {
		return new ResponseEntity<Object>("not found beby", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}
