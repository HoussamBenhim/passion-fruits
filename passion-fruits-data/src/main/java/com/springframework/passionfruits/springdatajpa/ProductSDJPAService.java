package com.springframework.passionfruits.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.repositories.ProductRepository;
import com.springframework.passionfruits.services.ProductService;

@Profile("springdatajpa")
@Service

public class ProductSDJPAService implements ProductService {
	private final ProductRepository productRepository;
	
	public ProductSDJPAService(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public Set<Product> findAll() {
		Set<Product> products = new HashSet<>();
		productRepository.findAll().forEach(products::add);
		return products;
	}

	@Override
	public Product findById(Long id) {
		return productRepository.findById(id).orElse(null);
	}

	@Override
	public Product save(Product entity) {
		return productRepository.save(entity);
	}

	@Override
	public void delete(Product entity) {
		productRepository.delete(entity);
	}

	@Override
	public void deleteById(Long id) {
		productRepository.deleteById(id);
	}

	@Override
	public Product findByName(String name) {
		return productRepository.findByName(name);
	}

}
