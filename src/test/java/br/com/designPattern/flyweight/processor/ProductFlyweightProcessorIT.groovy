package br.com.designPattern.flyweight.processor

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.domain.Product
import br.com.designPatterns.flyweight.enums.BrandProduct
import br.com.designPatterns.flyweight.processor.ProductFlyweightProcessor
import br.com.designPatterns.flyweight.service.impl.ProductAFlyweightService
import br.com.designPatterns.flyweight.service.impl.ProductBFlyweightService
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class ProductFlyweightProcessorIT extends Specification {
	
	@Autowired
	private ProductFlyweightProcessor productFlyweightProcessor
	
	def "Should get ProductAFlyweightService of ProductFlyweightService and save product with valid name and description"() {
		given:
			def product = new Product(name: "Test A", description: "Test", brand: BrandProduct.A)
			
		when:
			def service = productFlyweightProcessor.getService(product.brand)
			def result = service.save(product)
		
		then:
			service instanceof ProductAFlyweightService
			result.name == product.name
			result.brand == product.brand
	}
	
	def "Should get ProductAFlyweightService of ProductFlyweightService and return error if product is invalid"() {
		given:
			def product = new Product(name: "Test A", brand: BrandProduct.A)
			
		when:
			def service = productFlyweightProcessor.getService(product.brand)
			service.save(product)
		
		then:
			service instanceof ProductAFlyweightService
			def error = thrown(Exception)
			error.message == "Product ${product.name} is invalid!"
	}
	
	def "Should get ProductBFlyweightService of ProductFlyweightService and save product with valid name and description"() {
		given:
			def product = new Product(name: "Test B", , brand: BrandProduct.B)
			
		when:
			def service = productFlyweightProcessor.getService(product.brand)
			def result = service.save(product)
		
		then:
			service instanceof ProductBFlyweightService
			result.name == product.name
			result.brand == product.brand
	}
	
	def "Should get ProductBFlyweightService of ProductFlyweightService and return error if product is invalid"() {
		given:
			def product = new Product(brand: BrandProduct.B)
			
		when:
			def service = productFlyweightProcessor.getService(product.brand)
			service.save(product)
		
		then:
			service instanceof ProductBFlyweightService
			def error = thrown(Exception)
			error.message == "Product ${product.name} is invalid!"
	}
	
	def "Should return error if service not found"() {
		given:
			def product = new Product(name: "Test C", brand: BrandProduct.C)
			
		when:
			productFlyweightProcessor.getService(product.brand)
		
		then:
			def error = thrown(Exception)
			error.message == "Service not found to brand: C"
	}

}
