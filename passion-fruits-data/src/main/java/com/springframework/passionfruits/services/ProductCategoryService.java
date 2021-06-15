package com.springframework.passionfruits.services;

import java.util.Set;

import com.springframework.passionfruits.moddels.ProductCategory;

public interface ProductCategoryService {
	ProductCategory findByName(String name);
	ProductCategory findById(Long id);
	ProductCategory save(ProductCategory product);
	Set<ProductCategory> findAll();
}
