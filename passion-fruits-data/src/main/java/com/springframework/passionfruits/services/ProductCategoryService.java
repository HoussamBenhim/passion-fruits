package com.springframework.passionfruits.services;

import java.util.Set;

import com.springframework.passionfruits.moddels.ProductCategory;

public interface ProductCategoryService extends CrudService<ProductCategory, Long> {
	ProductCategory findByName(String name);
	ProductCategory updateCatregory(Long id, ProductCategory category);
	ProductCategory patchCatregory(Long id, ProductCategory category);
	
}
