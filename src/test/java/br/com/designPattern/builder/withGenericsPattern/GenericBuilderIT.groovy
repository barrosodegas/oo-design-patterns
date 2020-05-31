package br.com.designPattern.builder.withGenericsPattern

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.builder.withGenericsPattern.GenericBuilder
import br.com.designPatterns.builder.withGenericsPattern.impl.ContractGenericBuilder
import br.com.designPatterns.builder.withGenericsPattern.impl.PersonGenericBuilder
import br.com.designPatterns.domain.Contract
import br.com.designPatterns.domain.Person
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class GenericBuilderIT extends Specification {
	
	@Autowired
	private GenericBuilder<Person> personGenericBuilder;
	
	@Autowired
	private GenericBuilder<Contract> contractGenericBuilder;
	
	def "Should inject Person and Contract of GenericBuilder"() {
		when:
			def person = personGenericBuilder.newEntity()
			def contract = contractGenericBuilder.newEntity()
		then:
			personGenericBuilder instanceof PersonGenericBuilder
			contractGenericBuilder instanceof ContractGenericBuilder
			person instanceof Person
			contract instanceof Contract
	}

	def "Should create a new empty Person"() {
		when:
			def result = personGenericBuilder.newEntity()
		
		then:
			result instanceof Person
			!result.name
			!result.lastName
			result.age == 0
	}

	def "Should create a new Person with all attributes populated"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			attributes.putAt("name", "Luis")
			attributes.putAt("lastName", "Tester")
			attributes.putAt("age", 37)
			
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, attributes)
		
		then:
			result instanceof Person
			result.name == "Luis"
			result.lastName == "Tester"
			result.age == 37
	}
	
	def "Should create a new Person name attribute populated"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			attributes.putAt("name", "Luis")
			
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, attributes)
		
		then:
			result instanceof Person
			result.name == "Luis"
			!result.lastName
			result.age == 0
	}
	
	def "Should create a new Person lastName attribute populated"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			attributes.putAt("lastName", "Tester")
			
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, attributes)
		
		then:
			result instanceof Person
			!result.name
			result.lastName == "Tester"
			result.age == 0
	}
	
	def "Should create a new Person age attribute populated"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			attributes.putAt("age", 37)
			
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, attributes)
		
		then:
			result instanceof Person
			!result.name
			!result.lastName
			result.age == 37
	}
	
	def "Should return error if entity is null"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			attributes.putAt("age", 37)
			
		when:
			personGenericBuilder.newEntity(null, attributes)
		
		then:
			def error = thrown(Exception)
			error.message == "Entity is required!"
	}
	
	def "Should return error if attributes is null"() {
		given:
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, null)
		
		then:
			def error = thrown(Exception)
			error.message == "Attributes is required!"
	}
	
	def "Should return error if attributes is empty"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, attributes)
		
		then:
			def error = thrown(Exception)
			error.message == "Attributes is required!"
	}
	
	def "Should return not error if attirbute not exists"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			attributes.putAt("ag", 37)
			attributes.putAt("", null)
			
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, attributes)
		
		then:
			result
	}
	
	def "Should return not error if attirbute is empty or null"() {
		given:
			Map<String, Object> attributes = new HashMap<>()
			attributes.putAt("age", null)
			attributes.putAt("name", "")
			
			Person person = new Person()
			
		when:
			def result = personGenericBuilder.newEntity(person, attributes)
		
		then:
			result
			result.age == 0
			!result.name
	}

}
