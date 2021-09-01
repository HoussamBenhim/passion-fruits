package com.springframework.passionfruits.map;

import java.util.Set;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import com.springframework.passionfruits.moddels.Product;
import com.springframework.passionfruits.services.ProductCategoryService;
import com.springframework.passionfruits.services.ProductService;
import com.springframework.passionfruits.services.ProductSubCategoryService;

@Service
@Profile({"default", "map"})
public class ProductMapService extends AbstractMapService<Product, Long> implements ProductService{
	private final ProductSubCategoryService productSubCategoryService; 
	private final ProductCategoryService productCategoryService;
	
	public ProductMapService(ProductSubCategoryService productSubCategoryService,
			ProductCategoryService productCategoryService) {
		super();
		this.productSubCategoryService = productSubCategoryService;
		this.productCategoryService = productCategoryService;
	}
	
	@Override
	public Set<Product> findAll(){
		return super.findAll();
	}
	@Override
	public Product findById(Long id) {
		return super.findById(id);
	}

	@Override
	public Product save(Product entity) {
		if(entity==null) {
			return null;
		}
		if(entity.getProductSubCategory()==null) {
			throw new RuntimeException("Product SubCategory can't be null!");
		}else {
			if(entity.getProductSubCategory().getId()==null) {
				entity.setProductSubCategory(productSubCategoryService.save(entity.getProductSubCategory()));
				if(entity.getProductSubCategory().getProductCategory() ==null){
					throw new RuntimeException("Product Category can't be null!");
				}if(entity.getProductSubCategory().getProductCategory() .getId() ==null) {
					productCategoryService.save(entity.getProductSubCategory().getProductCategory());
				} 
			}
		}
		return super.save(entity);
	}

	@Override
	public void delete(Product entity) {
		super.delete(entity);
		
	}

	@Override
	public void deleteById(Long id) {
		super.deleteByID(id);
		
	}

	@Override
	public Product findByName(String name) {
		return this.findAll()
				.stream()
				.filter(product-> product.getName().equalsIgnoreCase(name))
				.findFirst().orElse(null);
	}


}
