package com.springframework.passionfruits.map;

import java.util.Set;

import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.services.CrudService;
import com.springframework.passionfruits.services.ProductCategoryService;

public class ProductCategoryMapService extends AbstractMapService<ProductCategory, Long> implements ProductCategoryService {

	@Override
	public ProductCategory save(ProductCategory entity) {
		return super.save(entity.getId(), entity);
	};

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
		
	};
	@Override
	public Set<ProductCategory> findAll(){
		return super.findAll();
	};
	@Override
	public void delete(ProductCategory product) {
		super.delete(product);
	};
	@Override
	public ProductCategory findById(Long id) {
		return super.findById(id);
	}

	@Override
	public ProductCategory findByName(String name) {
		
		return null;
	}

}
