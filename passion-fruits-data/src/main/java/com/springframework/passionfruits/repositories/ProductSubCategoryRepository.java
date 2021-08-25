package com.springframework.passionfruits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.passionfruits.moddels.ProductSubCategory;

public interface ProductSubCategoryRepository extends CrudRepository<ProductSubCategory, Long>{
  ProductSubCategory findBySubCtergoryName(String name);
}
