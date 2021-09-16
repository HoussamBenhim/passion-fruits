package com.springframework.passionfruits.services;

import com.springframework.passionfruits.moddels.ProductDescription;

public interface ProductDescriptionService extends CrudService<ProductDescription, Long> {
	ProductDescriptionService findByDescription(String description);
}
