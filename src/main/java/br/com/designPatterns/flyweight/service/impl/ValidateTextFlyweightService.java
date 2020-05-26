package br.com.designPatterns.flyweight.service.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.flyweight.enums.TypeService;
import br.com.designPatterns.flyweight.service.FlyweightService;

@Component
public class ValidateTextFlyweightService implements FlyweightService {

	@Override
	public boolean match(TypeService type) {
		return TypeService.TEXT.equals(type);
	}

	@Override
	public boolean validate(String value) {

		if(value == null) {
			return false;
		}
		return true;
	}

}
