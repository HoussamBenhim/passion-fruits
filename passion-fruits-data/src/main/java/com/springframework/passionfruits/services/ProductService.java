package com.springframework.passionfruits.services;

import java.util.Set;

import com.springframework.passionfruits.moddels.Product;

public interface ProductService extends CrudService<ProductService, Long> {
	Product findByName(String name);
}
