package com.springframework.passionfruits.controllers;

import java.util.Set;

import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.ProductService;

@RestController
public class ProductController {

	private final ProductService productService;
	private final MessageSource messageSource;  
	
	public ProductController(ProductService productService, MessageSource messageSource) {
		this.productService = productService;
		this.messageSource = messageSource;
	}

	@RequestMapping(method = RequestMethod.GET,value ="api/products")
	public Set<Product> getAllProduct() {
		return productService.findAll();
	}
	
	

	
}
