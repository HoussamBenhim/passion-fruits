package com.springframework.passionfruits.springdatajpa;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.passionfruits.Exceptions.ItemNotFoundException;
import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.moddels.ProductSubCategory;
import com.springframework.passionfruits.repositories.ProductCategoryRepository;
import com.springframework.passionfruits.services.ProductCategoryService;

import net.bytebuddy.implementation.bytecode.Throw;

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
		try {
			ProductCategory savedCategory = productCategoryRepository.findById(id).orElseThrow();
			Method[] methods = category.getClass().getDeclaredMethods();
			for (Method method : methods) {
				if (method.getName().startsWith("get")) {
					if (method.getReturnType() == Long.class) {
						if (method.invoke(category) != null) {
							savedCategory.getClass().getMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(savedCategory, (Long) method.invoke(category)) ;
						}
					} else if(method.getReturnType() == String.class) {
						if (method.invoke(category) != null) {
							savedCategory.getClass().getMethod("set" + method.getName().substring(3), method.getReturnType()).invoke(savedCategory, (String) method.invoke(category)) ;
						}
					} 
				}
			}
			return productCategoryRepository.save(savedCategory);
		} catch (Exception e) {
			throw new ItemNotFoundException("Category with id : " + id +"not found");
		}
		
	}

}
