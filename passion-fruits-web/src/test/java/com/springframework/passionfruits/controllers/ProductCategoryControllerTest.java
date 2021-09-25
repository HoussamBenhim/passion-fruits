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
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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

@SpringBootTest
@AutoConfigureMockMvc
class ProductCategoryControllerTest extends AbstractRestControllerTest {
	
	
	@MockBean
	ProductCategoryService productCategoryService;
	@Autowired
	ProductCategoryController categoryController;
	
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
		
		//String categoryJson = new JSONObject().put("categoryName", category.getCategoryName()).put("categoryDescription", category.getCategoryDescription()).put("id", category.getId().toString()).toString();
		when(productCategoryService.save(category)).thenReturn(category);		
		mockMvc.perform(post("/categories")
				.contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(category)))
		.andExpect(status().isOk())
		.andDo(print());
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
