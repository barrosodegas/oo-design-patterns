package br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.impl;

import org.springframework.stereotype.Component;

import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.NetworkTemplateMethodAbstract;
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.NetworkTemplateMethodStrategyGeneric;

@Component
public class XmlStringNetworkTemplateMethodSG extends NetworkTemplateMethodAbstract implements NetworkTemplateMethodStrategyGeneric<String> {

	@Override
	public void validate(String xmlString) throws Exception {
		
		if (xmlString == null || xmlString.isEmpty()) {
			throw new Exception("The parameter: xmlString is required!");
		}
		
		System.out.println("XML is valid!");
	}

	@Override
	public void login() throws Exception {
		
		if (getLoginAttributes() == null || getLoginAttributes().isEmpty()) {
			throw new Exception("The parameter: logginAttributes is required!");
		}
		
		System.out.println("Login success!");
	}

	@Override
	public void sendData(String xmlString) throws Exception {
		System.out.println(String.format("XML successfully sent!"));
	}

	@Override
	public void logout() throws Exception {
		
		if (getLoginAttributes() == null || getLoginAttributes().isEmpty()) {
			throw new Exception("The parameter: logginAttributes is required!");
		}
		
		System.out.println("Logout success!");
	}

}
