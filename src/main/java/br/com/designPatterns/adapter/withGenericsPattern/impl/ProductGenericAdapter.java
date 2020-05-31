package br.com.designPatterns.adapter.withGenericsPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.adapter.withGenericsPattern.GenericAdapter;
import br.com.designPatterns.domain.Product;
import br.com.designPatterns.dto.ProductDto;
import br.com.designPatterns.factory.withSingletonPattern.ProductFactorySingleton;

@Component
public class ProductGenericAdapter implements GenericAdapter<ProductDto, Product>{

	@Override
	public Product adapt(ProductDto dto) throws Exception {
		
		if (dto == null) {
			throw new Exception("Dto is required!");
		}
		
		Product product = ProductFactorySingleton.createNewProduct();
		
		product.setName(dto.getName());
		product.setDescription(dto.getShortDescription());
		product.setPrice(dto.getValue());
		product.setAmount(dto.getAmount());
		product.setBrand(dto.getCompany());
		
		return product;
	}

}
