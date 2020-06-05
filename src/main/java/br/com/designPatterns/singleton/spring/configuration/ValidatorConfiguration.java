package br.com.designPatterns.singleton.spring.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.designPatterns.singleton.spring.bean.ValidatorSingleton;

@Configuration
public class ValidatorConfiguration {

	/**
	 * By default, Spring beans are singletons.
	 * 
	 * @return ValidatorSingleton
	 */
	@Bean
	public ValidatorSingleton validatorSingleton() {
		return new ValidatorSingleton();
	}
	
}
