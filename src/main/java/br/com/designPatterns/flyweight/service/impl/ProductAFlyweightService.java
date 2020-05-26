package br.com.designPatterns.flyweight.service.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.domain.Product;
import br.com.designPatterns.flyweight.enums.BrandProduct;
import br.com.designPatterns.flyweight.service.ProductFlyweightService;

@Component
public class ProductAFlyweightService implements ProductFlyweightService {

	@Override
	public boolean match(BrandProduct brandProduct) {
		return BrandProduct.A.equals(brandProduct);
	}

	@Override
	public Product save(Product product) throws Exception {
		
		if(!validate(product)) {
			throw new Exception(String.format("Product %s is invalid!", product.getName()));
		}
		System.out.println(String.format("Product %s saved!", product.getName()));
		return product;
	}

	private boolean validate(Product product) {
		
		boolean isValid = false;
		if(product != null && product.getName() != null && product.getDescription() != null) {
			isValid = true;
		}
		return isValid;
	}

}
