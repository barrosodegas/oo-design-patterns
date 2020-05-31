package br.com.designPattern.adapter.withStrategyPattern

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.adapter.withStrategyPattern.StrategyAdapter
import br.com.designPatterns.adapter.withStrategyPattern.impl.ProductStrategyAdapter
import br.com.designPatterns.dto.ProductDto
import br.com.designPatterns.flyweight.enums.BrandProduct
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class StrategyAdapterIT extends Specification {
	
	@Autowired
	private StrategyAdapter strategyAdapter
	
	def "Should inject StrategyAdapter instance"() {
		when: "I have the attirbute"
			strategyAdapter

		then:
			strategyAdapter instanceof ProductStrategyAdapter
	}

	def "Should return error if ProductDto is null"() {
		given:
			def productDto = null
		
		when:
			strategyAdapter.adapt(productDto)	
		
		then:
			def error = thrown(Exception)
			error.message == "Dto is required!"	
	}
	
	def "Should create a new Product if ProductDto is not null"() {
		given:
			def productDto = new ProductDto(name: "Test", shortDescription: "Adapter test", value: BigDecimal.ONE, amount: 1, company: BrandProduct.A)
		
		when:
			def product = strategyAdapter.adapt(productDto)
			
		then:
			product
			product.name == productDto.name
			product.description == productDto.shortDescription
			product.price == productDto.value
			product.amount == productDto.amount
			product.brand == productDto.company
	}
	
}
