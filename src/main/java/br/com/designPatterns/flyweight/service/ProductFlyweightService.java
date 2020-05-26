package br.com.designPatterns.flyweight.service;

import br.com.designPatterns.domain.Product;
import br.com.designPatterns.flyweight.enums.BrandProduct;

public interface ProductFlyweightService {

	public boolean match(BrandProduct brandProduct);
	
	public Product save(Product product) throws Exception;
	
}
