package com.springframework.passionfruits.controllers;

import java.util.Set;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.services.ProductCategoryService;

@RestController
public class ProductCategoryController {

	private final ProductCategoryService productCategoryService;
	
	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	
	@RequestMapping({"/categories"})
	public Set<ProductCategory> listAllProductCategories(){
		return productCategoryService.findAll();
	}
	
}
