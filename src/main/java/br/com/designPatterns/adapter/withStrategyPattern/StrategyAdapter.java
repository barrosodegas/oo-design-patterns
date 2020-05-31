package br.com.designPatterns.adapter.withStrategyPattern;

import br.com.designPatterns.domain.Product;
import br.com.designPatterns.dto.ProductDto;

public interface StrategyAdapter {

	public Product adapt(ProductDto productDto) throws Exception;
	
}
