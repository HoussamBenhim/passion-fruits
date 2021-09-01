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
@AllArgsConstructor
@Builder
@Entity
@Table(name = "product_category" )
public class ProductCategory extends BaseEntity {

	@Column(name = "category_name")
	private String categoryName;
	@Column(name = "description")
	private String categoryDescription;
//	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "productCategory")
//	private Set<Product> products = new HashSet<>(); 
	@JsonBackReference
	@OneToMany(cascade = CascadeType.REMOVE, mappedBy = "productCategory")
	private Set<ProductSubCategory> productSubCategory = new HashSet<>(); 

	
	
}
