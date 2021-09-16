package com.springframework.passionfruits.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.services.ProductCategoryService;
import com.springframework.passionfruits.services.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
class ProductCategoryControllerTest {
	
	
	@Mock
	ProductCategoryService productCategoryService;
	@InjectMocks
	ProductCategoryController categoryController;
	@Autowired
	MockMvc mockMvc;
	ProductCategory category;
	Set<ProductCategory> listCategories;
	String categoryName;
	@BeforeEach
	void setUp() throws Exception {
		listCategories= new HashSet<>();
		listCategories.add(ProductCategory.builder().id(1L).categoryName("FRUITS").build());
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
		 categoryName= "FRUITS";
		 category = new ProductCategory();
		 category.setCategoryName("FRUITS");
		 category.setId(1L);
	}

	@Test
	void testListAllProductCategories() {
		
		try {
			when(productCategoryService.findAll()).thenReturn(listCategories);
			mockMvc.perform(get("/categories/list"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$[0].categoryName", is("FRUITS")));	
			verify(productCategoryService, times(1)).findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	void testGetCategory() {
		
		try {
			when(productCategoryService.findByName(categoryName)).thenReturn(category);
			mockMvc.perform(get("/categories/FRUITS"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.categoryName", is("FRUITS")));
			verify(productCategoryService, times(1)).findByName(categoryName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
