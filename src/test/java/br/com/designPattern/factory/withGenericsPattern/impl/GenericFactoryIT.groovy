package br.com.designPattern.factory.withGenericsPattern.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.domain.Contract
import br.com.designPatterns.domain.Person
import br.com.designPatterns.factory.withGenericsPattern.GenericFactory
import br.com.designPatterns.factory.withGenericsPattern.impl.GenericContractFactory
import br.com.designPatterns.factory.withGenericsPattern.impl.GenericPersonFactory
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class GenericFactoryIT extends Specification {
	
	@Autowired
	private GenericFactory<Person> personFactory;
	
	@Autowired
	private GenericFactory<Contract> contractFactory;

	def "Should instantiate an object of type GenericPersonFactory and create a new person"() {
		when:
			def person = personFactory.getNewEntity()
		
		then:
			personFactory instanceof GenericPersonFactory
			person
	}
	
	def "Should instantiate an object of type GenericContractFactory and create a new contract"() {
		when:
			def contract = contractFactory.getNewEntity()
		
		then:
			contractFactory instanceof GenericContractFactory
			contract
	}
	
}
