package com.springframework.passionfruits.moddels;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor

@Entity
@Table(name = "product_category" )
public class ProductCategory extends BaseEntity {
	
	@Builder
	public ProductCategory(Long id,String categoryName, String categoryDescription,
			Set<ProductSubCategory> productSubCategory) {
		super(id);
		this.categoryName = categoryName;
		this.categoryDescription = categoryDescription;
		this.productSubCategory = productSubCategory;
	}
	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "description")
	private String categoryDescription;
//	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "productCategory")
//	private Set<Product> products = new HashSet<>(); 
	@JsonManagedReference
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "productCategory")
	private Set<ProductSubCategory> productSubCategory = new HashSet<>(); 

	
	
}
