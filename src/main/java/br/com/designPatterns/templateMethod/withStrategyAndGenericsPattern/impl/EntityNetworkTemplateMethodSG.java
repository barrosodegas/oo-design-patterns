package br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.domain.Product;
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.NetworkTemplateMethodAbstract;
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.NetworkTemplateMethodStrategyGeneric;

@Component
public class EntityNetworkTemplateMethodSG extends NetworkTemplateMethodAbstract implements NetworkTemplateMethodStrategyGeneric<Product> {

	@Override
	public void validate(Product entity) throws Exception {
		
		if (entity == null) {
			throw new Exception("The parameter: product is required!");
		}
		
		System.out.println("Product is valid!");
	}

	@Override
	public void login() throws Exception {
		
		if (getLoginAttributes() == null || getLoginAttributes().isEmpty()) {
			throw new Exception("The parameter: logginAttributes is required!");
		}
		
		System.out.println("Login success!");
	}

	@Override
	public void sendData(Product entity) throws Exception {
		System.out.println(String.format("Product %s successfully sent!", entity.getName()));
	}

	@Override
	public void logout() throws Exception {
		
		if (getLoginAttributes() == null || getLoginAttributes().isEmpty()) {
			throw new Exception("The parameter: logginAttributes is required!");
		}
		
		System.out.println("Logout success!");
	}

}
