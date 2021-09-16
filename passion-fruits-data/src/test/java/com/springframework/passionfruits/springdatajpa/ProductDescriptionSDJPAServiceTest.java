package com.springframework.passionfruits.springdatajpa;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.springframework.passionfruits.moddels.ProductDescription;
import com.springframework.passionfruits.repositories.ProductDescriptionRepository;

@ExtendWith(MockitoExtension.class)
class ProductDescriptionSDJPAServiceTest {
	Set<ProductDescription> listProductDescription;
	
	@Mock
	ProductDescriptionRepository descriptionRepository;
	@InjectMocks
	ProductDescriptionSDJPAService descriptionService;
	@BeforeEach
	void setUp() throws Exception {
		listProductDescription= new HashSet<>();
		ProductDescription decription1 = new ProductDescription();
		decription1.setId(1L);
		decription1.setDescription("description 1");
		ProductDescription decription2 = new ProductDescription();
		decription2.setId(2L);
		decription2.setDescription("description 2");
		listProductDescription.add(decription1);
		listProductDescription.add(decription2);
		
		
	}

	@Test
	void testFindAll() {
		when(descriptionRepository.findAll()).thenReturn(listProductDescription);
		Set<ProductDescription> returnedList= descriptionService.findAll();
		assertNotNull(returnedList);
		assertEquals(2, returnedList.size());
	}

}
