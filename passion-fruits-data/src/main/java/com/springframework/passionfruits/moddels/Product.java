package com.springframework.passionfruits.moddels;

public class Product extends BaseEntity{

	
	private String name;
	private Long price;
	private String origin;
	private String descrption;
	private Integer valeur_nutritionnelle;
	private String conservation;
	private String culture;
	private String image_url;
	private ProductCategory productCategory;
	private ProductSubCategory subCategory;
	
	
	public ProductCategory getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(ProductCategory productCategory) {
		this.productCategory = productCategory;
	}
	public ProductSubCategory getSubCategory() {
		return subCategory;
	}
	public void setSubCategory(ProductSubCategory subCategory) {
		this.subCategory = subCategory;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
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
