package com.springframework.passionfruits.map;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.moddels.ProductSubCategory;


class ProductMapServiceTest2 {

	ProductMapService productMapService;
	ProductSubCategoryMapService productSubCategoryMapService;
	ProductCategoryMapService productCategoryMapService;
	Long productId = 1L;
	String name= "pomme";
	@BeforeEach
	void setUp() throws Exception {
		productSubCategoryMapService = new ProductSubCategoryMapService();
		productCategoryMapService= new ProductCategoryMapService();
		ProductCategory productCat = ProductCategory.builder().categoryName("Fruits").build();
		ProductSubCategory productSubCat = ProductSubCategory.builder().subCtergoryName("fruits rouges").build();
		productSubCategoryMapService.save(productSubCat);
		productCategoryMapService.save(productCat);
		productMapService = new ProductMapService(productSubCategoryMapService, productCategoryMapService);
		System.out.println(productCategoryMapService.findByName("Fruits"));
		Product product = Product.builder().id(productId).name(name).productCategory(productCat).productSubCategory(productSubCat).build();
		productMapService.save(product);
	
	}

	@Test
	void testProductMapService() {
		fail("Not yet implemented");
	}

	@Test
	void testFindAll() {
		Set<Product> products= productMapService.findAll();
		assertEquals(1, products.size());
	}

	@Test
	void testFindByIdLong() {
		Product product = productMapService.findById(productId);
		assertEquals(productId, product.getId());
	}

	@Test
	void testSaveProductExistingId() {
		Long id =1L;
		Product product2= Product.builder().id(id).productCategory(productCategoryMapService.findById(id)).build();
		Product productSaved = productMapService.save(product2);
		assertEquals(id, productSaved.getId());
	}

	@Test
	void testSaveProductNoId() {
		Long id =1L;
		Product product3= Product.builder().productCategory(productCategoryMapService.findById(id)).build();
		Product productSaved = productMapService.save(product3);
		assertNotNull(productSaved);
		assertNotNull(productSaved.getId());
	}
	
	@Test
	void testDeleteProduct() {
		productMapService.delete(productMapService.findById(productId));
		assertEquals(0, productMapService.findAll().size());
	}

	@Test
	void testDeleteById() {
		productMapService.deleteById(productId);
		assertEquals(0, productMapService.findAll().size());
	}

	@Test
	void testFindByName() {
		Product product = productMapService.findByName(name);
		assertNotNull(product);
		assertEquals(1, product.getId());
	}
	@Test
	void testFindByNameNotFound() {
		Product product = productMapService.findByName("foo");
		assertNull(product);
	}

}
	