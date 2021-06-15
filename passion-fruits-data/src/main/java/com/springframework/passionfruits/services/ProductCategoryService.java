package com.springframework.passionfruits.services;

import java.util.Set;

import com.springframework.passionfruits.moddels.ProductCategory;

public interface ProductCategoryService extends CrudService<ProductCategory, Long> {
	ProductCategory findByName(String name);
}
