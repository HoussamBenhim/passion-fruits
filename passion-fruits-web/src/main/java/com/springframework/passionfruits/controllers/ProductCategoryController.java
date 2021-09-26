package com.springframework.passionfruits.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(method = RequestMethod.GET,value ="/list")
	public ResponseEntity<?> listAllProductCategories(){
		return ResponseEntity.ok().body(productCategoryService.findAll());
	}
	
	@GetMapping({"/{categoryName}"})
	public ProductCategory getCategory(@PathVariable String categoryName){
		return productCategoryService.findByName(categoryName);
		
	}
	
	@PostMapping
	public ResponseEntity<?> createCategory(@RequestBody ProductCategory category){
		return new ResponseEntity<ProductCategory>(productCategoryService.save(category), HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable Long id, @RequestBody ProductCategory category){
		return new ResponseEntity<ProductCategory>(productCategoryService.updateCatregory(id,category), HttpStatus.OK);
	}
}
