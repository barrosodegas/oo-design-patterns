package br.com.designPatterns.flyweight.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.designPatterns.flyweight.enums.BrandProduct;
import br.com.designPatterns.flyweight.service.ProductFlyweightService;

@Component
public class ProductFlyweightProcessor {
	
	@Autowired
	private List<ProductFlyweightService> productFlyweightServices;
	
	public ProductFlyweightService getService(BrandProduct brandProduct) throws Exception {
		
		return productFlyweightServices.stream()
				.filter(it -> it.match(brandProduct))
				.findFirst()
				.orElseThrow(() -> new Exception(String.format("Service not found to brand: %s", brandProduct)));
	}

}
