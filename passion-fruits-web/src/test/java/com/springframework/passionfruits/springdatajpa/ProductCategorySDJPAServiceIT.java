package com.springframework.passionfruits.springdatajpa;


import static org.assertj.core.api.Assertions.not;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.configuration.MockAnnotationProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.springframework.passionfruits.configForProfileTest;
import com.springframework.passionfruits.bootstrap.DataInitializer;
import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.repositories.ProductCategoryRepository;
import com.springframework.passionfruits.repositories.ProductRepository;
import com.springframework.passionfruits.repositories.ProductSubCategoryRepository;
import com.springframework.passionfruits.services.ProductCategoryService;
import com.springframework.passionfruits.services.ProductService;
import com.springframework.passionfruits.services.ProductSubCategoryService;

@RunWith(SpringRunner.class)
@SpringBootTest

class ProductCategorySDJPAServiceIT {
	@Autowired
	ProductCategoryRepository categoryRepository;
	@Autowired
	ProductRepository productRepository;
	@Autowired
	ProductSubCategoryRepository productsubRepository;
	
	ProductSDJPAService productService;
	 
	ProductCategorySDJPAService productCategoryService;
	
	
	ProductSubCategorySDJPAService productSubCategoryService;
	@InjectMocks
	configForProfileTest configTest;

	

	@BeforeEach
	void setUp() throws Exception {
		productService = new ProductSDJPAService(productRepository);
		productCategoryService = new ProductCategorySDJPAService(categoryRepository);
		productSubCategoryService = new ProductSubCategorySDJPAService(productsubRepository);
		
		//MockitoAnnotations.initMocks(this);
	
		
		//bootstrap.run(); // load data
	}

	@Test
	void testpatchCatergoryUpdateName() {
		ProductCategory category = ProductCategory.builder().categoryName("Test").id(23L).categoryDescription("description Test").build();
		if(  categoryRepository.findByCategoryName(category.getCategoryName()) ==null  ) {			
			categoryRepository.save(category);
		}
		Set<ProductCategory> list = new HashSet<>();
		categoryRepository.findAll().forEach(list::add);
		Long id = !list.isEmpty() ? list.iterator().next().getId() : 0 ;
		String updateName = "UpdateName";
		if(id== 0) {
			fail("no element in the database");
		}
		ProductCategory saevedcategory = categoryRepository.findById(id).orElse(null);
		assertNotNull(saevedcategory);
		String originalCategoryName = saevedcategory.getCategoryName();
		String originalDescription = saevedcategory.getCategoryDescription(); 
		saevedcategory.setCategoryName(updateName);
		productCategoryService.patchCatregory(id, saevedcategory);
		ProductCategory updatedCategory = categoryRepository.findById(id).orElse(null);
		assertNotNull(updatedCategory);
		assertEquals(updatedCategory.getCategoryName(), updateName);
		assertNotEquals(originalCategoryName, updatedCategory.getCategoryName());
		assertEquals(originalDescription, updatedCategory.getCategoryDescription());
		
	}


}
