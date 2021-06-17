package com.springframework.passionfruits.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.ProductService;
@Service
public class ProductMapService extends AbstractMapService<Product, Long> implements ProductService{
	@Override
	public Set<Product> findAll(){
		return super.findAll();
	}
	@Override
	public Product findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Product save(Product entity) {
		return super.save( entity);
	}

	@Override
	public void delete(Product entity) {
		super.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
		
	}

	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


}
