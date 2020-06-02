package br.com.designPattern.strategy.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.strategy.enums.FunctionEnum
import br.com.designPatterns.strategy.service.CommissionStrategyEnumService
import spock.lang.Specification


@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class CommissionStrategyEnumServiceIT extends Specification {
	
	@Autowired
	private CommissionStrategyEnumService commissionStrategyEnumService
	
	def "Should return error if commission not found"() {
		given:
			def function = FunctionEnum.PRESIDENT
			def value = BigDecimal.ONE
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Commission not found to function: PRESIDENT!"
	}

	def "Should return error if function is null"() {
		given:
			def function = null
			def value = BigDecimal.ONE
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)	
			
		then:
			def error = thrown(Exception)
			error.message == "Function is required!"
	}	
	
	def "Should return error if value is null to calculate SALESMAN commission"() {
		given:
			def function = FunctionEnum.SALESMAN
			def value = null
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should return error if value is zero to calculate SALESMAN commission"() {
		given:
			def function = FunctionEnum.SALESMAN
			def value = BigDecimal.ZERO
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should return error if value is less than zero to calculate SALESMAN commission"() {
		given:
			def function = FunctionEnum.SALESMAN
			def value = new BigDecimal("-1")
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should calculate commission if value is greater than zero to SALESMAN commission"() {
		given:
			def function = FunctionEnum.SALESMAN
			def value = BigDecimal.ONE
			
		when:
			def result = commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			noExceptionThrown()
			result
			result.compareTo(BigDecimal.ZERO) > 0
	}
	
	def "Should return error if value is null to calculate MANAGER commission"() {
		given:
			def function = FunctionEnum.MANAGER
			def value = null
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should return error if value is zero to calculate MANAGER commission"() {
		given:
			def function = FunctionEnum.MANAGER
			def value = BigDecimal.ZERO
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should return error if value is less than zero to calculate MANAGER commission"() {
		given:
			def function = FunctionEnum.MANAGER
			def value = new BigDecimal("-1")
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should calculate commission if value is greater than zero to MANAGER commission"() {
		given:
			def function = FunctionEnum.MANAGER
			def value = BigDecimal.ONE
			
		when:
			def result = commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			noExceptionThrown()
			result
			result.compareTo(BigDecimal.ZERO) > 0
	}
	
	def "Should return error if value is null to calculate DIRECTOR commission"() {
		given:
			def function = FunctionEnum.DIRECTOR
			def value = null
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should return error if value is zero to calculate DIRECTOR commission"() {
		given:
			def function = FunctionEnum.DIRECTOR
			def value = BigDecimal.ZERO
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should return error if value is less than zero to calculate DIRECTOR commission"() {
		given:
			def function = FunctionEnum.DIRECTOR
			def value = new BigDecimal("-1")
			
		when:
			commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			def error = thrown(Exception)
			error.message == "Value is required!"
	}
	
	def "Should calculate commission if value is greater than zero to DIRECTOR commission"() {
		given:
			def function = FunctionEnum.DIRECTOR
			def value = BigDecimal.ONE
			
		when:
			def result = commissionStrategyEnumService.calculateCommissionByFunction(function, value)
			
		then:
			noExceptionThrown()
			result
			result.compareTo(BigDecimal.ZERO) > 0
	}

}
