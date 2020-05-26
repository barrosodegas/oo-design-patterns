package br.com.designPatterns.flyweight.processor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.designPatterns.flyweight.enums.TypeService;
import br.com.designPatterns.flyweight.service.FlyweightService;

@Component
public class FlyweightProcessor {

	@Autowired
	private List<FlyweightService> flyweightServices;
	
	public FlyweightService getService(TypeService type) throws Exception {
		
		return flyweightServices.stream()
				.filter(it -> it.match(type))
				.findFirst()
				.orElseThrow(() -> new Exception(String.format("Service not found to type: %s", type)));
	}
	
}
