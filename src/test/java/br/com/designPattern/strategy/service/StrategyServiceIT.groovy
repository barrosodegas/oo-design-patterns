package br.com.designPattern.strategy.service

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.boot.test.context.SpringBootContextLoader
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.ContextConfiguration

import br.com.designPatterns.DesignPatternsApplication
import br.com.designPatterns.strategy.service.StrategyService
import br.com.designPatterns.strategy.service.impl.PersistFileStrategyService
import br.com.designPatterns.strategy.service.impl.PersistMongoStrategyService
import br.com.designPatterns.strategy.service.impl.PersistPostgreStrategyService
import spock.lang.Specification

@ActiveProfiles(value = ['test'])
@ContextConfiguration(loader = SpringBootContextLoader, classes = [DesignPatternsApplication])
@SpringBootTest(classes = [DesignPatternsApplication])
class StrategyServiceIT extends Specification {

	@Autowired
	@Qualifier(value = "persistFileStrategyService")
	private StrategyService persistFileStrategyService;
		
	@Autowired
	@Qualifier(value = "persistMongoStrategyService")
	private StrategyService persistMongoStrategyService;
	
	@Autowired
	@Qualifier(value = "persistPostgreStrategyService")
	private StrategyService persistPostgreStrategyService;
	
	@Autowired
	private List<StrategyService> strategyServices;
	
	def "Sould get PersistFileStrategyService of StrategyService and save value in file"() {
		given:
			String value = "Test"
		
		when:
			def result = persistFileStrategyService.save(value)
			
		then:
			persistFileStrategyService instanceof PersistFileStrategyService
			result == value
	}
	
	def "Sould get PersistMongoStrategyService of StrategyService and save value in Mongo DB"() {
		given:
			String value = "Test"
		
		when:
			def result = persistMongoStrategyService.save(value)
			
		then:
			persistMongoStrategyService instanceof PersistMongoStrategyService
			result == value
	}
	
	def "Sould get PersistPostgreStrategyService of StrategyService and save value in Postgre DB"() {
		given:
			String value = "Test"
		
		when:
			def result = persistPostgreStrategyService.save(value)
			
		then:
			persistPostgreStrategyService instanceof PersistPostgreStrategyService
			result == value
	}
	
	def "Sould get all StrategyServices and save value in File, Mongo DB and Postgre DB"() {
		given:
			String value = "Test"
		
		when:
			def resultFile = strategyServices.first().save(value)
			def resultMongo = strategyServices.get(1).save(value)
			def resultPostgre = strategyServices.last().save(value)
			
		then:
			strategyServices.first() instanceof PersistFileStrategyService
			strategyServices.get(1) instanceof PersistMongoStrategyService
			strategyServices.last() instanceof PersistPostgreStrategyService
			
			resultFile == value
			resultMongo == value
			resultPostgre == value
	}

}
