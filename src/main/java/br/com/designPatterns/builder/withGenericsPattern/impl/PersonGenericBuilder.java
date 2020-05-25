package br.com.designPatterns.builder.withGenericsPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.builder.withGenericsPattern.GenericBuilder;
import br.com.designPatterns.domain.Person;

@Component
public class PersonGenericBuilder implements GenericBuilder<Person> {

	@Override
	public Person newEntity() {
		return new Person();
	}

}
