package br.com.designPatterns.factory.withSingletonPattern;

import br.com.designPatterns.domain.Product;

public class ProductFactorySingleton {

	private ProductFactorySingleton() { }

	public static Product createNewProduct() {
		return new Product();
	}
	
}
