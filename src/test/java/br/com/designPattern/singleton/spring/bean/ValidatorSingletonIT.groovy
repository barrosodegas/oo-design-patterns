package br.com.designPattern.singleton.spring.bean

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.singleton.spring.bean.ValidatorSingleton
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class ValidatorSingletonIT extends Specification {

	@Autowired
	private ValidatorSingleton validatorSingleton
	
	@Autowired
	private ValidatorSingleton validatorSingleton2

	def "Should inject the same instance into the variables"() {
		when:
			validatorSingleton
			validatorSingleton2
			
		then:
			validatorSingleton instanceof ValidatorSingleton
			validatorSingleton2 instanceof ValidatorSingleton
			validatorSingleton == validatorSingleton2
			validatorSingleton.hashCode() == validatorSingleton2.hashCode()
	}
		
}
