package br.com.designPatterns.flyweight.service;

import br.com.designPatterns.flyweight.enums.TypeService;

public interface FlyweightService {
	
	public boolean match(TypeService type);

	public boolean validate(String value);
	
}
