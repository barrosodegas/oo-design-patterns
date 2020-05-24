package br.com.designPatterns.factory.withBuilderPattern;

import org.springframework.stereotype.Component;

import br.com.designPatterns.factory.domain.Person;

@Component
public class PersonFactoryBuilder {
	
	public Person createPerson() {
		return new Person();
	}
	
	public Person createPerson(String name) {
		return new Person(name);
	}
	
	public Person createPerson(String name, String lastName) {
		return new Person(name, lastName);
	}
	
}
