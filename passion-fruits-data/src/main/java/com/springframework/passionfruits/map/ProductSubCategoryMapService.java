package com.springframework.passionfruits.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springframework.passionfruits.moddels.ProductSubCategory;
import com.springframework.passionfruits.services.ProductSubCategoryService;

@Service
public class ProductSubCategoryMapService extends AbstractMapService<ProductSubCategory, Long> implements ProductSubCategoryService{
	@Override
	public ProductSubCategory save(ProductSubCategory entity) {
		return super.save( entity);
	};

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
		
	};
	@Override
	public Set<ProductSubCategory> findAll(){
		return super.findAll();
	};
	@Override
	public void delete(ProductSubCategory product) {
		super.delete(product);
	};
	@Override
	public ProductSubCategory findById(Long id) {
		return super.findById(id);
	}

	@Override
	public ProductSubCategory findByName(String name) {
		
		return null;
	}
}
