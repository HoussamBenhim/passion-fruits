package com.springframework.passionfruits.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import com.springframework.passionfruits.moddels.ProductSubCategory;
import com.springframework.passionfruits.repositories.ProductSubCategoryRepository;

@ExtendWith(MockitoExtension.class)
class ProductSubCategorySDJPAServiceTest {
	Long id = 1L;
	String subCatName = "fruits rouges";
	ProductSubCategory returnedSubCat;
	Set<ProductSubCategory> productSubCats;
	@Mock
	ProductSubCategoryRepository productSubCategoryRepository;
	@InjectMocks
	ProductSubCategorySDJPAService productSubCategorySDJPAService;

	@BeforeEach
	void setUp() throws Exception {
		returnedSubCat = ProductSubCategory.builder().id(id).subCtergoryName(subCatName).subCategoryDescription("rien")
				.build();
	}

	@Test
	void testFindAll() {
		productSubCats = new HashSet<>();
		productSubCats.add(new ProductSubCategory());
		productSubCats.add(new ProductSubCategory());
		when(productSubCategoryRepository.findAll()).thenReturn(productSubCats);
		Set<ProductSubCategory> returnedSet = productSubCategorySDJPAService.findAll();
		assertNotNull(returnedSet);
		assertEquals(2, returnedSet.size());
	}

	@Test
	void testFindById() {
		when(productSubCategoryRepository.findById(1L)).thenReturn(Optional.of(returnedSubCat));
		ProductSubCategory productSubCat = productSubCategorySDJPAService.findById(1L);
		assertNotNull(productSubCat);
		assertEquals("fruits rouges", productSubCat.getSubCtergoryName());
	}

	@Test
	void testSave() {
		ProductSubCategory productSubCat = ProductSubCategory.builder().build();
		when(productSubCategoryRepository.save(productSubCat)).thenReturn(productSubCat);
		ProductSubCategory savedSubProduct = productSubCategorySDJPAService.save(productSubCat);
		assertNotNull(savedSubProduct);
	}

	@Test
	void testDelete() {
		productSubCategorySDJPAService.delete(returnedSubCat);
		verify(productSubCategoryRepository, times(1)).delete(returnedSubCat);
	}

	@Test
	void testDeleteById() {
		productSubCategorySDJPAService.deleteById(id);
		verify(productSubCategoryRepository, times(1)).deleteById(org.mockito.Matchers.anyLong());
	}

	@Test
	void testFindByName() {
		when(productSubCategoryRepository.findBySubCtergoryName(org.mockito.Matchers.anyString()))
				.thenReturn(returnedSubCat);
		ProductSubCategory subCat = productSubCategorySDJPAService.findByName(subCatName);
		assertEquals(subCatName, subCat.getSubCtergoryName());
	}

}
