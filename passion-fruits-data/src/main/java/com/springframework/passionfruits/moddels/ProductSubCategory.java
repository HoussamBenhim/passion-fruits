package com.springframework.passionfruits.moddels;

public class ProductSubCategory extends BaseEntity{
 
	private String subCtergoryName;
	private String subCategoryDescription;

	public String getSubCtergoryName() {
		return subCtergoryName;
	}
	public void setSubCtergoryName(String subCtergoryName) {
		this.subCtergoryName = subCtergoryName;
	}
	public String getSubCategoryDescription() {
		return subCategoryDescription;
	}
	public void setSubCategoryDescription(String subCategoryDescription) {
		this.subCategoryDescription = subCategoryDescription;
	}
	
	
	
}
