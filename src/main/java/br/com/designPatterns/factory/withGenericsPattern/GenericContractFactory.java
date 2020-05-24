package br.com.designPatterns.factory.withGenericsPattern;

import org.springframework.stereotype.Component;

import br.com.designPatterns.factory.domain.Contract;

@Component
public class GenericContractFactory implements GenericFactory<Contract> {

	@Override
	public Contract getNewEntity() {
		return new Contract();
	}

}
