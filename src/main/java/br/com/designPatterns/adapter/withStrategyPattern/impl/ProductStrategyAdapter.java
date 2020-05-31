package br.com.designPatterns.adapter.withStrategyPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.adapter.withStrategyPattern.StrategyAdapter;
import br.com.designPatterns.domain.Product;
import br.com.designPatterns.dto.ProductDto;
import br.com.designPatterns.factory.withSingletonPattern.ProductFactorySingleton;

@Component
public class ProductStrategyAdapter implements StrategyAdapter {

	@Override
	public Product adapt(ProductDto productDto) throws Exception {
		
		if (productDto == null) {
			throw new Exception("Dto is required!");
		}
		
		Product product = ProductFactorySingleton.createNewProduct();
		
		product.setName(productDto.getName());
		product.setDescription(productDto.getShortDescription());
		product.setPrice(productDto.getValue());
		product.setAmount(productDto.getAmount());
		product.setBrand(productDto.getCompany());
		
		return product;
	}

}
