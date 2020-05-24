package br.com.designPatterns.factory.withGenericsPattern;

import org.springframework.stereotype.Component;

import br.com.designPatterns.factory.domain.Person;

@Component
public class GenericPersonFactory implements GenericFactory<Person>{

	@Override
	public Person getNewEntity() {
		return new Person();
	}
	
}
