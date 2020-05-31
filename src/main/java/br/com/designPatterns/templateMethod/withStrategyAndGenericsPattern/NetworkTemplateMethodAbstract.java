package br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern;

import java.util.Map;

public abstract class NetworkTemplateMethodAbstract {
	
	protected Map<String, Object> loginAttributes;

	public void setLoginAttributes(Map<String, Object> loginAttributes) {
		this.loginAttributes = loginAttributes;
	}

	public Map<String, Object> getLoginAttributes() {
		return this.loginAttributes;
	}

}
