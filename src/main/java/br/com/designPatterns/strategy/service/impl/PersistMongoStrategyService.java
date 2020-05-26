package br.com.designPatterns.strategy.service.impl;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.com.designPatterns.strategy.service.StrategyService;

@Order(2)
@Component(value = "persistMongoStrategyService")
public class PersistMongoStrategyService implements StrategyService {

	@Override
	public String save(String value) {

		System.out.println("Value saved in Mongo DB!");
		return value;
	}

}
