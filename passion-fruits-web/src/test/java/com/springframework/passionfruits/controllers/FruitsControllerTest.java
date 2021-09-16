package com.springframework.passionfruits.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
class FruitsControllerTest {
	@Mock
	ProductService productService;
	@InjectMocks
	FruitsController productController;
	Set<Product> products;
	@Autowired
	MockMvc mockMvc;
	private final Long ID =1L;
	@BeforeEach
	void setUp() throws Exception {
		products = new HashSet<>();
		products.add(Product.builder().id(1L).name("banane").build());
		products.add(Product.builder().id(2L).name("banane").build());
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	void testGetAllProduct() throws Exception {

		when(productService.findAll()).thenReturn(products);
		mockMvc.perform(get("/fruits/list"))
					.andExpect(status().isOk()).andExpect(jsonPath("$[0].name", is("banane")));

	}
	@Test
	public void testfindFruitByIdNotFound() throws Exception {
		Product product = null;
		when(productService.findById(1L)).thenReturn(product);
		mockMvc.perform(get("/fruits/1")).andExpect(status().is4xxClientError());
	}
	
	@Test
	void testfindFruitById() throws Exception {
		when(productService.findById(ID)).thenReturn(Product.builder().id(1L).name("banane").build());
		mockMvc.perform(get("/fruits/1"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name", is("banane")));
	}

}
