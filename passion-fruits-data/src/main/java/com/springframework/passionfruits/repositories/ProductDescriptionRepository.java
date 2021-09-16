package com.springframework.passionfruits.repositories;

import org.springframework.data.repository.CrudRepository;

import com.springframework.passionfruits.moddels.ProductDescription;

public interface ProductDescriptionRepository extends CrudRepository<ProductDescription, Long> {
}
