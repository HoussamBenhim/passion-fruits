package com.springframework.passionfruits.springdatajpa;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.repositories.ProductCategoryRepository;
import com.springframework.passionfruits.services.ProductCategoryService;
@Service
@Profile("springdatajpa")
public class ProductCategorySDJPAService implements ProductCategoryService {
	private final ProductCategoryRepository productCategoryRepository;

	public ProductCategorySDJPAService(ProductCategoryRepository productCategoryRepository) {
		super();
		this.productCategoryRepository = productCategoryRepository;
	}

	@Override
	public Set<ProductCategory> findAll() {
		Set<ProductCategory> productCats = new HashSet<>();
		productCategoryRepository.findAll().forEach(productCats::add);
		return productCats;
	}

	@Override
	public ProductCategory findById(Long id) {
		return productCategoryRepository.findById(id).orElse(null);
	}

	@Override
	public ProductCategory save(ProductCategory entity) {
		return productCategoryRepository.save(entity);
	}

	@Override
	public void delete(ProductCategory entity) {
		productCategoryRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		productCategoryRepository.deleteById(id);
	}

	@Override
	public ProductCategory findByName(String name) {
		return productCategoryRepository.findByCategoryName(name);
	}


	
}
