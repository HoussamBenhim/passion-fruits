package com.springframework.passionfruits.moddels;

public class ProductCategory extends BaseEntity {
 
	private String categoryName;
	private String categoryDescription;

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
	
}