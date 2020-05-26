package br.com.designPattern.flyweight.processor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.flyweight.enums.TypeService
import br.com.designPatterns.flyweight.processor.FlyweightProcessor
import br.com.designPatterns.flyweight.service.impl.ValidateNumberFlyweightService
import br.com.designPatterns.flyweight.service.impl.ValidateTextFlyweightService
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class FlyweightProcessorIT extends Specification {
	
	@Autowired
	private FlyweightProcessor flyweightProcessor;
	
	def "Should get ValidateNumberFlyweightService of FlyweightService and validate value as true"() {
		given:
			def value = "123"
			def TypeService number = TypeService.NUMBER
			
		when:
			def service = flyweightProcessor.getService(number)
			def result = service.validate(value)
		
		then:
			service instanceof ValidateNumberFlyweightService
			result	
	}
	
	def "Should get ValidateNumberFlyweightService of FlyweightService and validate value as false"() {
		given:
			def value = "1ds23"
			def TypeService number = TypeService.NUMBER
			
		when:
			def service = flyweightProcessor.getService(number)
			def result = service.validate(value)
		
		then:
			service instanceof ValidateNumberFlyweightService
			!result
	}
	
	def "Should get ValidateTextFlyweightService of FlyweightService and validate value as true"() {
		given:
			def value = "1ds23"
			def TypeService text = TypeService.TEXT
			
		when:
			def service = flyweightProcessor.getService(text)
			def result = service.validate(value)
		
		then:
			service instanceof ValidateTextFlyweightService
			result
	}
	
	def "Should get ValidateTextFlyweightService of FlyweightService and validate value as false"() {
		given:
			def value = null
			def TypeService number = TypeService.TEXT
			
		when:
			def service = flyweightProcessor.getService(number)
			def result = service.validate(value)
		
		then:
			service instanceof ValidateTextFlyweightService
			!result
	}
	
	def "Should return error if service not found"() {
		given:
			def value = new File("/tmp/test.csv")
			def TypeService file = TypeService.FILE
			
		when:
			flyweightProcessor.getService(file)
		
		then:
			def error = thrown(Exception)
			error.message == "Service not found to type: FILE"
	}

}
