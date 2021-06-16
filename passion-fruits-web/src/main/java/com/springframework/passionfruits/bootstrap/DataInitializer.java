package com.springframework.passionfruits.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.passionfruits.map.ProductCategoryMapService;
import com.springframework.passionfruits.map.ProductMapService;
import com.springframework.passionfruits.map.ProductSubCategoryMapService;
import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.moddels.ProductSubCategory;

@Component
public class DataInitializer implements CommandLineRunner{
	private final ProductMapService productMapService;
	private final ProductCategoryMapService productCategoryMapService;
	private final ProductSubCategoryMapService productSubCategoryMapService;
	
	public DataInitializer() {
		productMapService = new ProductMapService();
		productCategoryMapService = new ProductCategoryMapService();
		productSubCategoryMapService= new ProductSubCategoryMapService();
	}
	
	@Override
	public void run(String... args) throws Exception {
		ProductSubCategory productSubCategory1  = new ProductSubCategory();
		productSubCategory1.setId(1l);
		productSubCategory1.setSubCtergoryName("Fruits rouges");
		productSubCategoryMapService.save(productSubCategory1);
		ProductSubCategory productSubCategory2  = new ProductSubCategory();
		productSubCategory2.setId(2l);
		productSubCategory2.setSubCtergoryName("Fruits à noyeau");
		productSubCategoryMapService.save(productSubCategory2);
		
		System.out.println("Sub categories loaded");
		
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setCategoryName("Fruits");
		productCategory1.setCategoryDescription("Fruits avec un noyeau");
		productCategory1.setId(1L);
		productCategory1.setProductSubCategory(productSubCategory1);
		
		productCategoryMapService.save(productCategory1);
		
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setCategoryName("Fruits");
		productCategory2.setCategoryDescription("Fruits rouges");
		productCategory2.setId(2L);
		productCategory2.setProductSubCategory(productSubCategory2);
		productCategoryMapService.save(productCategory2);
		
		System.out.println("Product Categories Loaded");
		
		
		
		
		Product product1 = new Product();
		product1.setId(1L);
		product1.setName("Barquette Mirabelle - 350g");
		product1.setConservation("Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.");
		product1.setCulture("Agriculture raisonnée");
		product1.setDescrption("De belles myrtilles savoureuses, parce que sinon c'est pas vraiment l'été !");
		product1.setOrigin("Portugal / Espagne");
		product1.setImage_url("cherry-plum-5366060_640.jpg");
		product1.setPrice(3.5);
		product1.setProductCategory(productCategory1);
		
		product1.setValeur_nutritionnelle(40);
		productMapService.save(product1);
		
		Product product2 = new Product();
		product2.setId(2L);
		product2.setName("Barquette de cerise - Gard");
		product2.setConservation("Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.");
		product2.setCulture("Agriculture raisonnée");
		product2.setDescrption("De belles myrtilles savoureuses, parce que sinon c'est pas vraiment l'été !");
		product2.setOrigin("Maroc");
		product2.setImage_url("cherry-3074284_640.jpg");
		product2.setPrice(2.5);
		product2.setProductCategory(productCategory2);
		
		product2.setValeur_nutritionnelle(50);
		productMapService.save(product2);
		
		
		System.out.println("Loaded Products");
		
		
		
	}

	
}
