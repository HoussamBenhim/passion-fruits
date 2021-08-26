package com.springframework.passionfruits.moddels;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

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

	
	
}
