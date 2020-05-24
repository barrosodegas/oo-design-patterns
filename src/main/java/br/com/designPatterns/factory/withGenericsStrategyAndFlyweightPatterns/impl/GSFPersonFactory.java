package br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.factory.domain.Person;
import br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns.GenericsStrategyFlyweightFactory;

@Component
public class GSFPersonFactory implements GenericsStrategyFlyweightFactory<Person> {

	@Override
	public Person getInstance() {
		return new Person();
	}

	@Override
	public boolean match(Class type) {
		return Person.class.isAssignableFrom(type);
	}

}
