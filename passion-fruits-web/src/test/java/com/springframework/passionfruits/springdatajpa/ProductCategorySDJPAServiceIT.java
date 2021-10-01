package com.springframework.passionfruits.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.repositories.ProductCategoryRepository;
import com.springframework.passionfruits.repositories.ProductRepository;
import com.springframework.passionfruits.repositories.ProductSubCategoryRepository;


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

	

	@BeforeEach
	void setUp() throws Exception {
		productService = new ProductSDJPAService(productRepository);
		productCategoryService = new ProductCategorySDJPAService(categoryRepository);
		productSubCategoryService = new ProductSubCategorySDJPAService(productsubRepository);

	}

	@Test
	void testpatchCatergoryUpdateName() {
		String updateName = "UpdateName";
		ProductCategory category = ProductCategory.builder().categoryName("Test").id(23L).categoryDescription("description Test").build();
		if(  categoryRepository.findByCategoryName(category.getCategoryName()) ==null  ) {			
			categoryRepository.save(category);
		}
		if(categoryRepository.findByCategoryName(updateName) !=null) {
			categoryRepository.deleteById(categoryRepository.findByCategoryName(updateName).getId());
		}
		Set<ProductCategory> list = new HashSet<>();
		categoryRepository.findAll().forEach(list::add);
		Long id = !list.isEmpty() ? list.iterator().next().getId() : 0 ;
		
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
