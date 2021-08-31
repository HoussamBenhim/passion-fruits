package com.springframework.passionfruits.bootstrap;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.springframework.passionfruits.configForProfileTest;
import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.moddels.ProductCategory;
import com.springframework.passionfruits.moddels.ProductSubCategory;
import com.springframework.passionfruits.services.ProductCategoryService;
import com.springframework.passionfruits.services.ProductService;
import com.springframework.passionfruits.services.ProductSubCategoryService;

@Component
public class DataInitializer implements CommandLineRunner{
	private final ProductService productService;
	private final ProductCategoryService productCategoryService;
	private final ProductSubCategoryService productSubCategoryService;
	private final configForProfileTest configTest;
	
	@Autowired
	public DataInitializer(ProductService productService, ProductCategoryService productCategoryService,
			ProductSubCategoryService productSubCategoryService, configForProfileTest configTest) {
		
		this.productService = productService;
		this.productCategoryService = productCategoryService;
		this.productSubCategoryService = productSubCategoryService;
		this.configTest=configTest;
	}



	@Override
	public void run(String... args) throws Exception {

		
		ProductSubCategory productSubCategory1  = new ProductSubCategory();
		productSubCategory1.setSubCtergoryName("Fruits rouges");
		productSubCategory1= productSubCategoryService.save(productSubCategory1);
		ProductSubCategory productSubCategory2  = new ProductSubCategory();
		productSubCategory2.setSubCtergoryName("Fruits à noyeau");
		productSubCategory2=productSubCategoryService.save(productSubCategory2);
		ProductSubCategory productSubCategory3  = new ProductSubCategory();
		productSubCategory3.setSubCtergoryName("légumes frais");
		productSubCategory3=productSubCategoryService.save(productSubCategory3);
		
		
		Set<ProductSubCategory> set1= new HashSet();
		set1.add(productSubCategory1);
		Set<ProductSubCategory> set2= new HashSet();
		set2.add(productSubCategory2);
		Set<ProductSubCategory> set3= new HashSet();
		set3.add(productSubCategory1);
		set3.add(productSubCategory2);
		set3.add(productSubCategory3);
		
		System.out.println("Sub categories loaded");
		
		ProductCategory productCategory1 = new ProductCategory();
		productCategory1.setCategoryName("Fruits");
		productCategory1.setCategoryDescription("Fruits avec un noyeau");
		productCategory1.setProductSubCategory(set1);  
		productCategoryService.save(productCategory1);
		
		
		
		ProductCategory productCategory2 = new ProductCategory();
		productCategory2.setCategoryName("Fruits");
		productCategory2.setCategoryDescription("Fruits rouges");
		productCategory2.setProductSubCategory(set2);
		productCategoryService.save(productCategory2);
		
		ProductCategory productCategory3 = new ProductCategory();
		productCategory3.setCategoryName("légumes");
		productCategory3.setCategoryDescription("légumes frais");

		productCategory3.setProductSubCategory(set3);
		productCategoryService.save(productCategory3);
		System.	out.println("Product Categories Loaded");
		
		Product product1 = new Product();
		product1.setName("Barquette Mirabelle - 350g");
		product1.setConservation("Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.");
		product1.setCulture("Agriculture raisonnée");
		product1.setDescrption("De belles myrtilles savoureuses, parce que sinon c'est pas vraiment l'été !");
		product1.setOrigin("Portugal / Espagne");
		product1.setImage_url("cherry-plum-5366060_640.jpg");
		product1.setPrice(3.5);
		product1.setProductCategory(productCategory1);
		product1.setValeur_nutritionnelle(40);
		productService.save(product1);
		
		Product product2 = new Product();
		product2.setName("Barquette de cerise - Gard");
		product2.setConservation("Ce produit se conserve au réfrigérateur. Voir date limite de conservation sur l’emballage.");
		product2.setCulture("Agriculture raisonnée");
		product2.setDescrption("De belles myrtilles savoureuses, parce que sinon c'est pas vraiment l'été !");
		product2.setOrigin("Maroc");
		product2.setImage_url("cherry-3074284_640.jpg");
		product2.setPrice(2.5);
		product2.setProductCategory(productCategory3);
		
		product2.setValeur_nutritionnelle(50);
		productService.save(product2);
		
		
		System.out.println("---------------------Products Loaded----------------------- ");
		
		System.out.println(configTest.getUsername());
		System.out.println(configTest.getPassword());
		System.out.println(configTest.getJdbcurl());
		System.out.println(product2.getProductCategory().getId());
		
		System.out.println("---------------------subCategories Loaded----------------------- ");
		
		product2.getProductCategory().getProductSubCategory().forEach(subCat -> {
		System.out.println(subCat.getId());
		});
		System.out.println(product2.getProductCategory().getId());
		
	}

	
}
