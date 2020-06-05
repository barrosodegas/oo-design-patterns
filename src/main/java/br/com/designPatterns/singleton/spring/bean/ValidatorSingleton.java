package br.com.designPatterns.singleton.spring.bean;

import br.com.designPatterns.domain.Product;

public class ValidatorSingleton {

	public boolean validateProduct(Product product) {
		
		boolean isValid = true;
		if (product == null) {
			isValid = false;
		}
		return isValid;
	}
	
}
