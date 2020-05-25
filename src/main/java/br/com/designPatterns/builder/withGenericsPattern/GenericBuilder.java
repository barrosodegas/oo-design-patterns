package br.com.designPatterns.builder.withGenericsPattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class responsible for instantiating and popularizing entities.
 * 
 * ***
 * The second method was created to serve only as an example that it is possible to have a method so generic 
 * that you can pass the attributes dynamically. However, this type of implementation is not recommended because 
 * it is not performative and brings high processing and memory usage costs.
 * 
 * @author andrebarroso
 *
 * @param <E> Entity object.
 */
public interface GenericBuilder<E> {
	
	static final Logger log = LoggerFactory.getLogger(GenericBuilder.class);

	public E newEntity();
	
	/**
	 * It is recommended to use as the last possible solution.
	 * 
	 * @param entity Entity to be populated 
	 * @param attributes Attributes that will be assigned in the entity
	 * @return Entity populated
	 * @throws Exception Any error.
	 */
	default E newEntity(E entity, Map<String, Object> attributes) throws Exception {
		
		if(entity == null) throw new Exception("Entity is required!");
		if(attributes == null || attributes.isEmpty()) throw new Exception("Attributes is required!");
		
		attributes.entrySet().forEach( (entry) -> {
			
            if (!"class".equals(entry.getKey()) && !entry.getKey().isEmpty() && entry.getValue() != null) {
            	this.setProperty(entity, entry.getKey(), entry.getValue());
            }
        });
		
		return entity;
	}
	
	private void setProperty(E entity, String key, Object value) {
		
        try {
        	String setterName = String.format("set%s%s", key.split("")[0].toUpperCase(), key.substring(1, key.length()));
        	Class parameterTypeClass = getParameterClassType(entity, setterName);
    		Method setterMethod = entity.getClass().getMethod(setterName, parameterTypeClass);
    		setterMethod.invoke(entity, value);
		} 
        catch (NoSuchMethodException | SecurityException e) {
			log.error(String.format("Failed to try to process the attribute: [ %s ]", key), e);
		} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			log.error(String.format("Failed to try to process the attribute: [ %s ]", key), e);
		}
	}
	
	private Class getParameterClassType(E entity, String setterName) {
		
		Class classType = null;
		Method[] methods = entity.getClass().getMethods();
		for(int i = 0; i < methods.length; i++) {
			if(methods[i].getName().equals(setterName)) {
				classType = methods[i].getParameters()[0].getType();
				break;
			}
		}
		return classType;
	}
	
}
