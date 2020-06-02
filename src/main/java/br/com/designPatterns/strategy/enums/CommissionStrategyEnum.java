package br.com.designPatterns.strategy.enums;

import java.math.BigDecimal;

public enum CommissionStrategyEnum {

	SALESMAN {
		
		@Override
		public BigDecimal calculateCommission(BigDecimal value) throws Exception {
			
			validateValue(value);
			return value.multiply(new BigDecimal(0.1)).add(BigDecimal.ONE);
		}
	},
	MANAGER {
		
		@Override
		public BigDecimal calculateCommission(BigDecimal value) throws Exception {
			
			validateValue(value);
			return value.multiply(new BigDecimal(0.15)).add(new BigDecimal(5));
		}
	},
	DIRECTOR {
		
		@Override
		public BigDecimal calculateCommission(BigDecimal value) throws Exception {
			
			validateValue(value);
			return value.multiply(new BigDecimal(0.20)).add(new BigDecimal(10));
		}
	};
	
	public abstract BigDecimal calculateCommission(BigDecimal value) throws Exception;
	
	protected void validateValue(BigDecimal value) throws Exception {
		
		if(value == null || value.compareTo(BigDecimal.ZERO) <= 0) {
			throw new Exception("Value is required!");
		}
	}
	
}
