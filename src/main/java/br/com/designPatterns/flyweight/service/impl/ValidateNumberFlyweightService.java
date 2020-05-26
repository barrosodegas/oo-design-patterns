package br.com.designPatterns.flyweight.service.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.flyweight.enums.TypeService;
import br.com.designPatterns.flyweight.service.FlyweightService;

@Component
public class ValidateNumberFlyweightService implements FlyweightService {

	@Override
	public boolean match(TypeService type) {
		return TypeService.NUMBER.equals(type);
	}

	@Override
	public boolean validate(String value) {

		try {
			Integer.parseInt(value);
			return true;
		} 
		catch (Exception e) {
			return false;
		}
	}

}
