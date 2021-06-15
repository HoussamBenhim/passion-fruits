package com.springframework.passionfruits.map;

import java.util.Set;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.CrudService;

public class ProductMapService extends AbstractMapService<Product, Long> implements CrudService<Product, Long>{

	@Override
	public Product save(Product entity) {
		return super.save(entity.getId(), entity);
	};

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
		
	};
	@Override
	public Set<Product> findAll(){
		return super.findAll();
	};
	@Override
	public void delete(Product product) {
		super.delete(product);
	};
	@Override
	public Product findById(Long id) {
		return super.findById(id);
	}
	
}
