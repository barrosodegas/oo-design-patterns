package br.com.designPatterns.factory.withGenericsStrategyAndFlyweightPatterns;

public interface GenericsStrategyFlyweightFactory<E> {

	public E getInstance();
	
	public boolean match(Class type);
	
}
