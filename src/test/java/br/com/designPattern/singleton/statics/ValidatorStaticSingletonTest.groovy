package br.com.designPattern.singleton.statics

import br.com.designPatterns.singleton.statics.ValidatorStaticSingleton
import spock.lang.Specification

class ValidatorStaticSingletonTest extends Specification {
	
	def "Should inject the same instance into the variables"() {
		given:
			def validator1 = ValidatorStaticSingleton.getInstance()
			def validator2 = ValidatorStaticSingleton.getInstance()
			
		when:
			validator1.validateProduct(null)
			validator2.validateProduct(null)
			
		then:
			validator1 instanceof ValidatorStaticSingleton
			validator2 instanceof ValidatorStaticSingleton
			validator1 == validator2
			validator1.hashCode() == validator2.hashCode()
	}
		
}
