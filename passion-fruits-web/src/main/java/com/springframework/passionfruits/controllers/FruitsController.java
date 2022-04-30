package com.springframework.passionfruits.controllers;

import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springframework.passionfruits.exceptions.NotFoundException;
import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.ProductService;

@RequestMapping("/fruits")
@RestController
public class FruitsController {

	private final ProductService productService;

	public FruitsController(ProductService productService, MessageSource messageSource) {
		this.productService = productService;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public ResponseEntity<?> getAllProduct() {
		return ResponseEntity.ok().body(productService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> findFruitById(@PathVariable String id) {
		Product product=	productService.findById(Long.valueOf(id));
		if (product == null) {
			throw new NotFoundException("Fruit introuvable");
		}
		return ResponseEntity.ok().body(product);
	}
	/*test*/

}
