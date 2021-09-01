package com.springframework.passionfruits.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
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
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.ProductService;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {
	@Mock
	ProductService productService;
	@InjectMocks
	ProductController productController;
	Set<Product> products;
	@Autowired
	MockMvc mockMvc;
	@BeforeEach
	void setUp() throws Exception {
		products = new HashSet<>();
		products.add(Product.builder().id(1L).name("banane").build());
		products.add(Product.builder().id(2L).name("pomme").build());
		mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
	}

	@Test
	void testGetAllProduct() throws Exception {

		when(productService.findAll()).thenReturn(products);
		mockMvc.perform(get("/api/products"))
					.andExpect(status().isOk()).andExpect(jsonPath("$[0].name", is("pomme")));

	}

}