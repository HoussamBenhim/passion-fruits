package com.springframework.passionfruits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.passionfruits.moddels.ProductCategory;

public interface ProductCategoryRepository extends CrudRepository<ProductCategory, Long> {
	ProductCategory findByCategoryName(String name);
}
