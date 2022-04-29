package com.springframework.passionfruits.services;

import com.springframework.passionfruits.moddels.ProductSubCategory;

public interface ProductSubCategoryService extends CrudService<ProductSubCategory, Long> {
	ProductSubCategory findByName(String name);
}
