package com.springframework.passionfruits.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.services.ProductCategoryService;

@RequestMapping("/categories")
@RestController
public class ProductCategoryController {

	private final ProductCategoryService productCategoryService;
	
	public ProductCategoryController(ProductCategoryService productCategoryService) {
		this.productCategoryService = productCategoryService;
	}
	
	@GetMapping({"/list"})
	public Set<ProductCategory> listAllProductCategories(){
		return productCategoryService.findAll();
	}
	
	@GetMapping({"/{categoryName}"})
	public ProductCategory getCategory(@PathVariable String categoryName){
		return productCategoryService.findByName(categoryName);
		
	}
}
