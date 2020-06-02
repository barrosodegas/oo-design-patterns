package br.com.designPattern.strategy.enums

import br.com.designPatterns.strategy.enums.CommissionStrategyEnum
import spock.lang.Specification

class CommissionStrategyEnumTest extends Specification {
	
	def "Should return error if value is null"() {
		given:
			def value = null
			
		when:
			CommissionStrategyEnum.SALESMAN.calculateCommission(value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"		
	}
	
	def "Should return error if value is zero"() {
		given:
			def value = BigDecimal.ZERO
			
		when:
			CommissionStrategyEnum.SALESMAN.calculateCommission(value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should return commission if contains value greater than zero"() {
		given:
			def value = BigDecimal.ONE
			
		when:
			def result = CommissionStrategyEnum.SALESMAN.calculateCommission(value)
			
		then:
			noExceptionThrown()
			result
			result.compareTo(BigDecimal.ONE) > 0
	}

}
