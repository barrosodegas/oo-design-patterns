package br.com.designPatterns.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.designPatterns.flyweight.enums.BrandProduct;

public class ProductDto implements Serializable{

	/**
	 * UUID.
	 */
	private static final long serialVersionUID = -4856995726334575054L;

	private String name;
	
	private String shortDescription;
	
	private BigDecimal value;
	
	private Integer amount;
	
	private BrandProduct company;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public BrandProduct getCompany() {
		return company;
	}

	public void setCompany(BrandProduct company) {
		this.company = company;
	} 

}
