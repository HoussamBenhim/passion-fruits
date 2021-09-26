package com.springframework.passionfruits.controllers;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withServerError;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyObject;


import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.services.ProductCategoryService;
import com.springframework.passionfruits.services.ProductService;

class ProductCategoryControllerTest extends AbstractRestControllerTest {
	
	
	@Mock
	ProductCategoryService productCategoryService;
	@InjectMocks
	ProductCategoryController categoryController;
	
	MockMvc mockMvc;
	ProductCategory category;
	Set<ProductCategory> listCategories;
	String categoryName;
	@BeforeEach
	void setUp() throws Exception {
		listCategories= new HashSet<>();
		listCategories.add(ProductCategory.builder().id(1L).categoryName("FRUITS").build());
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(categoryController).build();
		 categoryName= "FRUITS";
		 category = new ProductCategory();
		 category.setCategoryName("FRUITS");
		 
		
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
	void testcreateCategory() throws Exception{
		ProductCategory newCategory = ProductCategory.builder().categoryName("Fruits").id(1L).build();
		ProductCategory savedCategory = ProductCategory.builder().categoryName("Fruits").id(1L).build();
		
		//String categoryJson = new JSONObject().put("categoryName", category.getCategoryName()).put("categoryDescription", category.getCategoryDescription()).put("id", category.getId().toString()).toString();
		when(productCategoryService.save(newCategory)).thenReturn(savedCategory);		
		String response = mockMvc.perform(post("/categories")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(category)))
		.andExpect(status().isCreated())
		.andReturn().getResponse().getContentAsString();
		System.out.println("response : " +response);
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
	
	@Test
	void testupdateCategory() throws Exception {
		ProductCategory category = new ProductCategory();
		category.setCategoryName("Legumes");
		Long id = 1L;
		ProductCategory returnedCategory = new ProductCategory();
		returnedCategory.setCategoryName("Legumes");
		returnedCategory.setId(id);
		
		when(productCategoryService.updateCatregory(anyLong(), anyObject())).thenReturn(returnedCategory);
		
		mockMvc.perform(put("/categories/1").contentType(MediaType.APPLICATION_JSON).content(asJsonString(category)))
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.categoryName", is("Legumes")))
					.andExpect(jsonPath("$.id", equalTo( "1") ));
		
	}
	
	
	

}
