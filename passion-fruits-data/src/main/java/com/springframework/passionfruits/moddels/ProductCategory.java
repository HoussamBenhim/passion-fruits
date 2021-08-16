package com.springframework.passionfruits.moddels;

import java.util.HashSet;
import java.util.Set;

public class ProductCategory extends BaseEntity {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String categoryName;
	private String categoryDescription;
	private Set<ProductSubCategory> productSubCategory = new HashSet<>(); 

	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getCategoryDescription() {
		return categoryDescription;
	}
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	public Set<ProductSubCategory> getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(Set<ProductSubCategory> productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	
	
}
