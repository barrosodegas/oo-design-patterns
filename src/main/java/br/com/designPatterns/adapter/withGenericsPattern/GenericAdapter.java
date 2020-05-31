package br.com.designPatterns.adapter.withGenericsPattern;

/**
 * 
 * @author andrebarroso
 *
 * @param <D> DTO
 * @param <E> Entity
 */
public interface GenericAdapter<D, E> {

	public E adapt(D dto) throws Exception;
	
}
