package br.com.designPatterns.factory.withSingletonPattern;

import br.com.designPatterns.domain.Person;

public class PersonFactorySingleton {
	
	private PersonFactorySingleton() { }

	public static Person createNewPerson() {
		return new Person();
	}
	
}
