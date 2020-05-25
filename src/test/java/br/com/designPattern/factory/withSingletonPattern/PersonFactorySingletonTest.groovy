package br.com.designPattern.factory.withSingletonPattern

import br.com.designPatterns.domain.Person
import br.com.designPatterns.factory.withSingletonPattern.PersonFactorySingleton
import spock.lang.Specification

class PersonFactorySingletonTest extends Specification {
	
	def "Shold crete a new person"() {
		when:
			def person = PersonFactorySingleton.createNewPerson()
		
		then: "I have a new person type object"
			person
			person instanceof Person
	}
	
}
