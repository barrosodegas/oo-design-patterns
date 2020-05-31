package br.com.designPatterns.builder.withGenericsPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.builder.withGenericsPattern.GenericBuilder;
import br.com.designPatterns.domain.Contract;

@Component
public class ContractGenericBuilder implements GenericBuilder<Contract> {

	@Override
	public Contract newEntity() {
		return new Contract();
	}

}
