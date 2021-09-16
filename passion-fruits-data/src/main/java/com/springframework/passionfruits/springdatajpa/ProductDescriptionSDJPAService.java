package com.springframework.passionfruits.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.springframework.passionfruits.moddels.ProductDescription;
import com.springframework.passionfruits.repositories.ProductDescriptionRepository;
import com.springframework.passionfruits.services.ProductDescriptionService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ProductDescriptionSDJPAService implements ProductDescriptionService {

	ProductDescriptionRepository descirptionRepository;
	
	public ProductDescriptionSDJPAService(ProductDescriptionRepository descirptionRepository) {
		super();
		this.descirptionRepository = descirptionRepository;
	}

	@Override
	public Set<ProductDescription> findAll() {
		Set<ProductDescription> listAllDescriptions = new HashSet<>();
		descirptionRepository.findAll().forEach(listAllDescriptions::add);
		return listAllDescriptions;
	}

	@Override
	public ProductDescription findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductDescription save(ProductDescription entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(ProductDescription entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ProductDescriptionService findByDescription(String description) {
		// TODO Auto-generated method stub
		return null;
	}

	



}
