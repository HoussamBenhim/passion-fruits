package com.springframework.passionfruits.services;


import java.util.Set;

import com.springframework.passionfruits.moddels.Product;

public interface ProductService extends CrudService<Product, Long> {
	Product findByName(String name);
}
