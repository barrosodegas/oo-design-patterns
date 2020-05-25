package br.com.designPattern.factory.withGenericsStrategyAndFlyweightPatterns

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.domain.Contract
import br.com.designPatterns.domain.Person
import br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns.GSFFactoryProvider
import br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns.GenericsStrategyFlyweightFactory
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class GSFFactoryProviderIT extends Specification {
	
	@Autowired
	private GSFFactoryProvider providerFactory;
	
	def "Should get GenericsStrategyFlyweightFactory factory and create a new person"() {
		given:
			def personClass = Person.class
			
		when:
			def factory = providerFactory.getFactory(personClass)	
		
		and:
			def person = factory.getInstance()
			
		then:
			factory instanceof GenericsStrategyFlyweightFactory
			person instanceof Person	
	}
	
	def "Should get GenericsStrategyFlyweightFactory factory and create a new contract"() {
		given:
			def contractClass = Contract.class
			
		when:
			def factory = providerFactory.getFactory(contractClass)
		
		and:
			def contract = factory.getInstance()
			
		then:
			factory instanceof GenericsStrategyFlyweightFactory
			contract instanceof Contract
	}

}
