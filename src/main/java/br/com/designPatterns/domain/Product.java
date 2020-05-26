package br.com.designPatterns.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.designPatterns.flyweight.enums.BrandProduct;

public class Product implements Serializable {

	/**
	 * UUID
	 */
	private static final long serialVersionUID = -964267428512528129L;

	private String name;
	
	private String description;
	
	private BigDecimal price;
	
	private Integer amount;
	
	private BrandProduct brand; 

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BrandProduct getBrand() {
		return brand;
	}

	public void setBrand(BrandProduct brand) {
		this.brand = brand;
	}
	
}
