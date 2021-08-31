package com.springframework.passionfruits.moddels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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
@Entity
@Table(name = "product")
public class Product extends BaseEntity{
	
	@Builder
	public Product(Long id, String name, Double price, String origin, String descrption, Integer valeur_nutritionnelle,
			String conservation, String culture, String image_url, ProductCategory productCategory,
			ProductSubCategory productSubCategory) {
		super(id);
		this.name = name;
		this.price = price;
		this.origin = origin;
		this.descrption = descrption;
		this.valeur_nutritionnelle = valeur_nutritionnelle;
		this.conservation = conservation;
		this.culture = culture;
		this.image_url = image_url;
		this.productCategory = productCategory;
		this.productSubCategory = productSubCategory;
	}
	@Column(name = "name")
	private String name;
	@Column(name = "price")
	private Double price;
	@Column(name = "origin")
	private String origin;
	@Column(name = "description")
	private String descrption;
	@Column(name = "nutrition_score")
	private Integer valeur_nutritionnelle;
	@Column(name = "conservation")
	private String conservation;
	@Column(name = "agriculture")
	private String culture;
	@Column(name = "picture")
	private String image_url;
	@ManyToOne
	@JoinColumn(name = "product_category_id")
	private ProductCategory productCategory;
	@ManyToOne
	@JoinColumn(name = "product_sub_cat_id")
	private ProductSubCategory productSubCategory;
	
}
