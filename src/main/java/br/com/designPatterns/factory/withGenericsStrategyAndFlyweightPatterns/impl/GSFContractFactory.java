package br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.domain.Contract;
import br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns.GenericsStrategyFlyweightFactory;

@Component
public class GSFContractFactory implements GenericsStrategyFlyweightFactory<Contract> {

	@Override
	public Contract getInstance() {
		return new Contract();
	}

	@Override
	public boolean match(Class type) {
		return Contract.class.isAssignableFrom(type);
	}

}
