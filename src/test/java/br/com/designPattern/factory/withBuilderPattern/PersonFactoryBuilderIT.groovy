package br.com.designPattern.factory.withBuilderPattern

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.domain.Person
import br.com.designPatterns.factory.withBuilderPattern.PersonFactoryBuilder
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class PersonFactoryBuilderIT extends Specification {
	
	@Autowired
	private PersonFactoryBuilder factoryBuilder;
	
	def "Shold create a new empty person"() {
		when:
			def person = factoryBuilder.createPerson()
		
		then: "I have a new person type object without name and last name"
			person
			person instanceof Person
			!person.getName()
			!person.getLastName()
	}	
	
	def "Shold create a new person with name"() {
		given:
			def name = "Luis"
		when:
			def person = factoryBuilder.createPerson(name)
		
		then: "I have a new person type object with name and without last name"
			person
			person instanceof Person
			person.getName() == name
			!person.getLastName()
	}
	
	def "Shold create a new person with name and last name"() {
		given:
			def name = "Luis"
			def lastName = "Tester"
		when:
			def person = factoryBuilder.createPerson(name, lastName)
		
		then: "I have a new person type object with name and last name"
			person
			person instanceof Person
			person.getName() == name
			person.getLastName() == lastName
	}
	
}
