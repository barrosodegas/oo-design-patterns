package br.com.designPattern.templateMethod.withStrategyAndGenericsPattern

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.domain.Product
import br.com.designPatterns.factory.withSingletonPattern.ProductFactorySingleton
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.NetworkTemplateMethodStrategyGeneric
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.impl.EntityNetworkTemplateMethodSG
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.impl.FileNetworkTemplateMethodSG
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.impl.XmlStringNetworkTemplateMethodSG
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class NetworkTemplateMethodStrategyGenericIT extends Specification {
	
	@Autowired
	private NetworkTemplateMethodStrategyGeneric<Product> entityNetworkTemplateMethodSG
	
	@Autowired
	private NetworkTemplateMethodStrategyGeneric<File> fileNetworkTemplateMethodSG
	
	@Autowired
	private NetworkTemplateMethodStrategyGeneric<String> xmlStringNetworkTemplateMethodSG
	
	def "Should inject instace of Entity, File and XmlString NetworkTemplateMethodStrategyGeneric"() {
		when: "I have the injection"
			entityNetworkTemplateMethodSG
			fileNetworkTemplateMethodSG
			xmlStringNetworkTemplateMethodSG
		
		then:
			entityNetworkTemplateMethodSG instanceof EntityNetworkTemplateMethodSG
			fileNetworkTemplateMethodSG instanceof FileNetworkTemplateMethodSG
			xmlStringNetworkTemplateMethodSG instanceof XmlStringNetworkTemplateMethodSG
	}
	
	def "Should return exception if product is null in the validate method"() {
		given:
			def product = null
		
		when:
			entityNetworkTemplateMethodSG.validate(product)
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: product is required!"
	}
	
	def "Should return exception if file is null in the validate method"() {
		given:
			def file = null
		
		when:
			fileNetworkTemplateMethodSG.validate(file)
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: file is required!"
	}
	
	def "Should return exception if xmlProduct is null in the validate method"() {
		given:
			def xmlString = null
		
		when:
			xmlStringNetworkTemplateMethodSG.validate(xmlString)
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: xmlString is required!"
	}
	
	def "Should return exception if loginAttributes to product is null in the login method"() {
		given:
			def loginAttributes = null
		
		when:
			entityNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			entityNetworkTemplateMethodSG.login()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to product is empty in the login method"() {
		given:
			def loginAttributes = [:]
		
		when:
			entityNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			entityNetworkTemplateMethodSG.login()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to file is null in the login method"() {
		given:
			def loginAttributes = null
		
		when:
			fileNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			fileNetworkTemplateMethodSG.login()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to file is empty in the login method"() {
		given:
			def loginAttributes = [:]
		
		when:
			fileNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			fileNetworkTemplateMethodSG.login()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to xmlString is null in the login method"() {
		given:
			def loginAttributes = null
		
		when:
			xmlStringNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			xmlStringNetworkTemplateMethodSG.login()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to xmlString is empty in the login method"() {
		given:
			def loginAttributes = [:]
		
		when:
			xmlStringNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			xmlStringNetworkTemplateMethodSG.login()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to product is null in the logout method"() {
		given:
			def loginAttributes = null
		
		when:
			entityNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			entityNetworkTemplateMethodSG.logout()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to product is empty in the logout method"() {
		given:
			def loginAttributes = [:]
		
		when:
			entityNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			entityNetworkTemplateMethodSG.logout()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to file is null in the logout method"() {
		given:
			def loginAttributes = null
		
		when:
			fileNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			fileNetworkTemplateMethodSG.logout()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to file is empty in the logout method"() {
		given:
			def loginAttributes = [:]
		
		when:
			fileNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			fileNetworkTemplateMethodSG.logout()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to xmlString is null in the logout method"() {
		given:
			def loginAttributes = null
		
		when:
			xmlStringNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			xmlStringNetworkTemplateMethodSG.logout()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should return exception if loginAttributes to xmlString is empty in the logout method"() {
		given:
			def loginAttributes = [:]
		
		when:
			xmlStringNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			xmlStringNetworkTemplateMethodSG.logout()
				
		then:
			def error = thrown(Exception)
			error.message == "The parameter: logginAttributes is required!"
	}
	
	def "Should post product entity with success"() {
		given:
			def loginAttributes = ["userName": "abs", "password": "xpto"]
			def product = ProductFactorySingleton.createNewProduct()
		
		when:
			entityNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			entityNetworkTemplateMethodSG.post(product)
				
		then:
			noExceptionThrown()
	}
	
	def "Should post file with success"() {
		given:
			def loginAttributes = ["userName": "abs", "password": "xpto"]
			def file = new File("/tmp/teste.csv")
		
		when:
			fileNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			fileNetworkTemplateMethodSG.post(file)
				
		then:
			noExceptionThrown()
	}
	
	def "Should post xmlString with success"() {
		given:
			def loginAttributes = ["userName": "abs", "password": "xpto"]
			def xmlString = "<name>Test</name>"
		
		when:
			xmlStringNetworkTemplateMethodSG.setLoginAttributes(loginAttributes)
			xmlStringNetworkTemplateMethodSG.post(xmlString)
				
		then:
			noExceptionThrown()
	}

}
