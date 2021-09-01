package com.springframework.passionfruits.moddels;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.springframework.passionfruits.map.ProductCategoryMapService;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "product_sub_category")
public class ProductSubCategory extends BaseEntity{
	@Column(name = "sub_category_name")
	private String subCtergoryName;
	@Column(name = "description")
	private String subCategoryDescription;
	
	@JsonManagedReference
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "productSubCategory")
	private Set<Product> products = new HashSet<>();
	
	@Builder
	public ProductSubCategory(Long id, String subCtergoryName, String subCategoryDescription,
			ProductCategory productCategory, Set<Product> products) {
		super(id);
		this.subCtergoryName = subCtergoryName;
		this.subCategoryDescription = subCategoryDescription;
		this.productCategory = productCategory;
		this.products = products;
	}
	
	
}
