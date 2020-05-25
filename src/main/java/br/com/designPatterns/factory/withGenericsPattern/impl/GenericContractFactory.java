package br.com.designPatterns.factory.withGenericsPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.domain.Contract;
import br.com.designPatterns.factory.withGenericsPattern.GenericFactory;

@Component
public class GenericContractFactory implements GenericFactory<Contract> {

	@Override
	public Contract getNewEntity() {
		return new Contract();
	}

}
