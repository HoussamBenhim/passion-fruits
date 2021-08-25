package com.springframework.passionfruits.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import com.springframework.passionfruits.moddels.ProductSubCategory;
import com.springframework.passionfruits.repositories.ProductSubCategoryRepository;
import com.springframework.passionfruits.services.ProductSubCategoryService;

public class ProductSubCategorySDJPAService implements ProductSubCategoryService{
	private final ProductSubCategoryRepository productSubCategoryRepository;

	
	public ProductSubCategorySDJPAService(ProductSubCategoryRepository productSubCategoryRepository) {
		super();
		this.productSubCategoryRepository = productSubCategoryRepository;
	}

	@Override
	public Set<ProductSubCategory> findAll() {
		Set<ProductSubCategory> subCategories = new HashSet<>();
		productSubCategoryRepository.findAll().forEach(subCategories::add);
		return subCategories;
	}

	@Override
	public ProductSubCategory findById(Long id) {
		return productSubCategoryRepository.findById(id).orElse(null);
	}

	@Override
	public ProductSubCategory save(ProductSubCategory entity) {
		return productSubCategoryRepository.save(entity);
	}

	@Override
	public void delete(ProductSubCategory entity) {
		productSubCategoryRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		productSubCategoryRepository.deleteById(id);
	}

	@Override
	public ProductSubCategory findByName(String name) {
		return productSubCategoryRepository.findBySubCtergoryName(name);
	}
	
}
