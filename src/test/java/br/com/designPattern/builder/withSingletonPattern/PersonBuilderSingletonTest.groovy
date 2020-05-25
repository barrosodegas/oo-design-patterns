package br.com.designPattern.builder.withSingletonPattern

import br.com.designPatterns.builder.withSingletonPattern.PersonBuilderSingleton
import spock.lang.Specification

class PersonBuilderSingletonTest extends Specification {
	
	def "Should create a new empty Person"() {
		when:
			def person = PersonBuilderSingleton.build()
		
		then:
			person
			!person.name
			!person.lastName
			person.age == 0	
	}
	
	def "Should create a new Person with name"() {
		given:
			def name = "Luis"
		
		when:
			def person = PersonBuilderSingleton.buildWith(name)
		
		then:
			person
			person.name == name
			!person.lastName
			person.age == 0
	}
	
	def "Should create a new Person name and last name"() {
		given:
			def name = "Luis"
			def lastName = "Tester"
		
		when:
			def person = PersonBuilderSingleton.buildWith(name, lastName)
		
		then:
			person
			person.name == name
			person.lastName == lastName
			person.age == 0
	}
	
	def "Should create a new Person with name, last name and age"() {
		given:
			def name = "Luis"
			def lastName = "Tester"
			def age = 37

		when:
			def person = PersonBuilderSingleton.buildWith(name, lastName, age)
		
		then:
			person
			person.name == name
			person.lastName == lastName
			person.age == age
	}

}
