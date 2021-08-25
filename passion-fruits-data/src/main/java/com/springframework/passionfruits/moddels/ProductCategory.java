package com.springframework.passionfruits.moddels;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
@Entity
@Table(name = "product_categories" )
public class ProductCategory extends BaseEntity {
 
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "description")
	private String categoryDescription;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productCategory")
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
