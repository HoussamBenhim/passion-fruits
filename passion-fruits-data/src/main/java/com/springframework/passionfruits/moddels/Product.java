package com.springframework.passionfruits.moddels;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product extends BaseEntity{

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
	
	
	public ProductSubCategory getProductSubCategory() {
		return productSubCategory;
	}
	public void setProductSubCategory(ProductSubCategory productSubCategory) {
		this.productSubCategory = productSubCategory;
	}
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getOrigin() {
		return origin;
	}
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	public String getDescrption() {
		return descrption;
	}
	public void setDescrption(String descrption) {
		this.descrption = descrption;
	}
	public Integer getValeur_nutritionnelle() {
		return valeur_nutritionnelle;
	}
	public void setValeur_nutritionnelle(Integer valeur_nutritionnelle) {
		this.valeur_nutritionnelle = valeur_nutritionnelle;
	}
	public String getConservation() {
		return conservation;
	}
	public void setConservation(String conservation) {
		this.conservation = conservation;
	}
	public String getCulture() {
		return culture;
	}
	public void setCulture(String culture) {
		this.culture = culture;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}
	
	
}
