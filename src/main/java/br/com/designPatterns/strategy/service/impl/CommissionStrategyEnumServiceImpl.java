package br.com.designPatterns.strategy.service.impl;

import java.math.BigDecimal;
import java.util.EnumMap;

import org.springframework.stereotype.Component;

import br.com.designPatterns.strategy.enums.CommissionStrategyEnum;
import br.com.designPatterns.strategy.enums.FunctionEnum;
import br.com.designPatterns.strategy.service.CommissionStrategyEnumService;

@Component
public class CommissionStrategyEnumServiceImpl implements CommissionStrategyEnumService {
	
	private EnumMap<FunctionEnum, CommissionStrategyEnum> commissions;
	
	public CommissionStrategyEnumServiceImpl() {
		
		commissions = new EnumMap<FunctionEnum, CommissionStrategyEnum>(FunctionEnum.class);
		commissions.put(FunctionEnum.SALESMAN, CommissionStrategyEnum.SALESMAN);
		commissions.put(FunctionEnum.MANAGER, CommissionStrategyEnum.MANAGER);
		commissions.put(FunctionEnum.DIRECTOR, CommissionStrategyEnum.DIRECTOR);
	}

	@Override
	public BigDecimal calculateCommissionByFunction(FunctionEnum function, BigDecimal value) throws Exception {
		
		validate(function, value);
		return commissions.get(function).calculateCommission(value);
	}

	private void validate(FunctionEnum function, BigDecimal value) throws Exception {
		
		if (function == null) {
			throw new Exception("Function is required!");
		}
		
		if (!commissions.containsKey(function)) {
			throw new Exception(String.format("Commission not found to function: %s!", function));
		}
		
		if (value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("Value is required!");
		}
		
	}

}
