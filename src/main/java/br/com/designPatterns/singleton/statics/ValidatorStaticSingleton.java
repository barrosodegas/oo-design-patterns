package br.com.designPatterns.singleton.statics;

import br.com.designPatterns.domain.Product;

public final class ValidatorStaticSingleton {

	private static final ValidatorStaticSingleton INSTANCE = new ValidatorStaticSingleton();
	
	public static synchronized ValidatorStaticSingleton getInstance() {
		return INSTANCE;
	}
	
	public boolean validateProduct(Product product) {
		
		boolean isValid = true;
		if (product == null) {
			isValid = false;
		}
		return isValid;
	}

}
