package com.springframework.passionfruits.moddels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
@Builder
@Entity
@Table(name = "product_sub_categories")
public class ProductSubCategory extends BaseEntity{
	@Column(name = "sub_category_name")
	private String subCtergoryName;
	@Column(name = "description")
	private String subCategoryDescription;
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;

	
}
