package br.com.designPatterns.builder.withSingletonPattern;

import br.com.designPatterns.domain.Person;

public class PersonBuilderSingleton {

	private PersonBuilderSingleton() { }
	
	public static Person build() {
		return new Person();
	}
	
	public static Person buildWith(String name) {
		return new Person(name);
	}
	
	public static Person buildWith(String name, String lastName) {
		return new Person(name, lastName);
	}
	
	public static Person buildWith(String name, String lastName, int age) {
		return new Person(name, lastName, age);
	}
	
}
