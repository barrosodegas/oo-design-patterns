package br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns;

import org.springframework.stereotype.Component;

import br.com.designPatterns.factory.domain.Person;

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
