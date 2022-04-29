package com.springframework.passionfruits.springdatajpa;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.passionfruits.Exceptions.ItemNotFoundException;
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

	@Override
	public ProductCategory updateCatregory(Long id, ProductCategory category) {
		category.setId(id);
		return productCategoryRepository.save(category);
	}

	@Override
	public ProductCategory patchCatregory(Long id, ProductCategory category) {
		ProductCategory savedCategory = productCategoryRepository.findById(id)
				.orElseThrow(() -> new ItemNotFoundException("Category with id : " + id + "not found"));
		try {
			Method[] methods = category.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					if (method.getReturnType() == Long.class) {
						if (method.invoke(category) != null) {
							savedCategory.getClass()
									.getMethod("set" + method.getName().substring(3), method.getReturnType())
									.invoke(savedCategory, (Long) method.invoke(category));
						}
					} else if (method.getReturnType() == String.class) {
						if (method.invoke(category) != null) {
							savedCategory.getClass()
									.getMethod("set" + method.getName().substring(3), method.getReturnType())
									.invoke(savedCategory, (String) method.invoke(category));
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return productCategoryRepository.save(savedCategory);
	}

}
