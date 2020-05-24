package br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class GSFFactoryProvider {

	private List<GenericsStrategyFlyweightFactory> factories;
	
	public GSFFactoryProvider(List<GenericsStrategyFlyweightFactory> factories) {
		this.factories = factories;
	}
	
	public GenericsStrategyFlyweightFactory getFactory(Class type) throws Exception {
		
		return this.factories.stream()
				.filter(it -> it.match(type))
				.findFirst()
				.orElseThrow(() -> new Exception(String.format("Factory [ %s ] not found!", type)));
	}
	
}
