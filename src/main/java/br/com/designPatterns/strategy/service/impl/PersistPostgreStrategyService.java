package br.com.designPatterns.strategy.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.designPatterns.strategy.service.StrategyService;

@Order(3)
@Component(value = "persistPostgreStrategyService")
public class PersistPostgreStrategyService implements StrategyService {

	@Override
	public String save(String value) {
		
		System.out.println("Value saved in Postgre DB!");
		return value;
	}

}
