package com.springframework.passionfruits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.passionfruits.moddels.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{
	Product findByName(String name);
}
