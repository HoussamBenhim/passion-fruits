package com.springframework.passionfruits.controllers;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.ProductService;

@RestController
public class ProductController {

	private final ProductService productService;
	
	
	public ProductController(ProductService productService) {
		this.productService = productService;
	}


	@RequestMapping({"","/","/products"})
	public Set<Product> getAllProduct() {
		Set<Product> listProduct =  productService.findAll();
		return listProduct;
	}
}
