package br.com.designPatterns.strategy.service;

import java.math.BigDecimal;

import br.com.designPatterns.strategy.enums.FunctionEnum;

public interface CommissionStrategyEnumService {

	public BigDecimal calculateCommissionByFunction(FunctionEnum function, BigDecimal value) throws Exception;
	
}
