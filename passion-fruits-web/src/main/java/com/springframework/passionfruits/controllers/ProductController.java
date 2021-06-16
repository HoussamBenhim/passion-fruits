package com.springframework.passionfruits.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.passionfruits.moddels.Product;

@RestController
public class ProductController {

	@RequestMapping({"","/","products"})
	public Product getAllProduct() {
		
		return null;
	}
}
