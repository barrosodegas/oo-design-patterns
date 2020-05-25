package br.com.designPatterns.factory.withGenericsPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.domain.Person;
import br.com.designPatterns.factory.withGenericsPattern.GenericFactory;

@Component
public class GenericPersonFactory implements GenericFactory<Person>{

	@Override
	public Person getNewEntity() {
		return new Person();
	}
	
}
