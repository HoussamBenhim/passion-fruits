package com.springframework.passionfruits.springdatajpa;

import java.util.HashSet;
import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.passionfruits.moddels.ProductDescription;
import com.springframework.passionfruits.repositories.ProductDescriptionRepository;
import com.springframework.passionfruits.services.ProductDescriptionService;

@Profile("springdatajpa")
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

		return null;
	}

	@Override
	public ProductDescription save(ProductDescription entity) {

		return null;
	}

	@Override
	public void delete(ProductDescription entity) {

	}

	@Override
	public void deleteById(Long id) {

	}

	@Override
	public ProductDescriptionService findByDescription(String description) {

		return null;
	}

}
