package com.springframework.passionfruits.map;

import java.util.Set;

import com.springframework.passionfruits.moddels.ProductSubCategory;
import com.springframework.passionfruits.services.CrudService;

public class ProductSubCategoryMapService extends AbstractMapService<ProductSubCategory, Long> implements CrudService<ProductSubCategory, Long>{
	@Override
	public ProductSubCategory save(ProductSubCategory entity) {
		return super.save(entity.getId(), entity);
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
}
