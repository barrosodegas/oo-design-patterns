package br.com.designPatterns.strategy.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.designPatterns.strategy.service.StrategyService;

@Order(1)
@Component(value = "persistFileStrategyService")
public class PersistFileStrategyService implements StrategyService {

	@Override
	public String save(String value) {
		
		System.out.println("Value saved in File!");
		return value;
	}

}
