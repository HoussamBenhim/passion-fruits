package com.springframework.passionfruits.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.moddels.ProductSubCategory;
import com.springframework.passionfruits.services.ProductCategoryService;
import com.springframework.passionfruits.services.ProductService;
import com.springframework.passionfruits.services.ProductSubCategoryService;

@Profile("default")
@Component
public class DataInitializer implements CommandLineRunner{
	private final ProductService productService;
	private final ProductCategoryService productCategoryService;
	private final ProductSubCategoryService productSubCategoryService;

	
	@Autowired
	public DataInitializer(ProductService productService, ProductCategoryService productCategoryService,
			ProductSubCategoryService productSubCategoryService) {
		
		this.productService = productService;
		this.productCategoryService = productCategoryService;
		this.productSubCategoryService = productSubCategoryService;

	}



	@Override
	public void run(String... args) throws Exception {

		
		ProductSubCategory productSubCategoryFruitsRouges  = new ProductSubCategory();
		productSubCategoryFruitsRouges.setSubCtergoryName("Fruits rouges");
		
		ProductSubCategory productSubCategoryFruitNoyeau  = new ProductSubCategory();
		productSubCategoryFruitNoyeau.setSubCtergoryName("Fruits à noyeau");
		
		ProductSubCategory productSubCategoryLegumesJaunes  = new ProductSubCategory();
		productSubCategoryLegumesJaunes.setSubCtergoryName("légumes jaune");
		
		
		
		Set<ProductSubCategory> listsouscategoryfruits= new HashSet();
		listsouscategoryfruits.add(productSubCategoryFruitsRouges);
		listsouscategoryfruits.add(productSubCategoryFruitNoyeau);
		
		Set<ProductSubCategory> listsouscategorylégumes= new HashSet();
		listsouscategorylégumes.add(productSubCategoryLegumesJaunes);
		
		
		
		System.out.println("Sub categories loaded");
		
		ProductCategory productCategoryFruits = new ProductCategory();
		productCategoryFruits.setCategoryName("EPICERIE1");
		productCategoryFruits.setCategoryDescription("Fruits avec un noyeau");
		productCategoryFruits.setProductSubCategory(listsouscategoryfruits);  
		productCategoryFruits = productCategoryService.save(productCategoryFruits);
		productSubCategoryFruitsRouges.setProductCategory(productCategoryFruits);
		productSubCategoryFruitsRouges= productSubCategoryService.save(productSubCategoryFruitsRouges);
		productSubCategoryFruitNoyeau.setProductCategory(productCategoryFruits);
		productSubCategoryFruitNoyeau=productSubCategoryService.save(productSubCategoryFruitNoyeau);
		ProductCategory productCategoryLegumes = new ProductCategory();
		productCategoryLegumes.setCategoryName("EPICERIE2");
		productCategoryLegumes.setCategoryDescription("Fruits avec un noyeau");
		productCategoryLegumes.setProductSubCategory(listsouscategorylégumes);  
		productCategoryLegumes =productCategoryService.save(productCategoryLegumes);
		productSubCategoryLegumesJaunes.setProductCategory(productCategoryLegumes);
		productSubCategoryLegumesJaunes=productSubCategoryService.save(productSubCategoryLegumesJaunes);

		System.	out.println("Product Categories Loaded");
		
		Product product1 = new Product();
		product1.setName("Barquette Mirabelle - 350g");
		product1.setConservation("Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.");
		product1.setCulture("Agriculture raisonnée");
		product1.setDescription("De belles myrtilles savoureuses, parce que sinon c'est pas vraiment l'été !");
		product1.setOrigin("Portugal / Espagne");
		product1.setImage_url("cherry-plum-5366060_640.jpg");
		product1.setPrice(3.5);
		product1.setValeur_nutritionnelle(40);
		product1.setProductSubCategory(productSubCategoryFruitsRouges);
		productService.save(product1);
		
		Product product2 = new Product();
		product2.setName("Barquette de Carotte - Gard");
		product2.setConservation("Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.");
		product2.setCulture("Agriculture raisonnée");
		product2.setDescription("De belles myrtilles savoureuses, parce que sinon c'est pas vraiment l'été !");
		product2.setOrigin("Maroc");
		product2.setImage_url("cherry-3074284_640.jpg");
		product2.setPrice(2.5);
		product2.setProductSubCategory(productSubCategoryLegumesJaunes);
		product2.setValeur_nutritionnelle(50);
		productService.save(product2);
		
	

		
	}

	
}
