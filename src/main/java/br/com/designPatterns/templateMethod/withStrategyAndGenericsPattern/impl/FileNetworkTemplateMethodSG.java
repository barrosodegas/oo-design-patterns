package br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.impl;

import java.io.File;

import org.springframework.stereotype.Component;

import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.NetworkTemplateMethodAbstract;
import br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern.NetworkTemplateMethodStrategyGeneric;

@Component
public class FileNetworkTemplateMethodSG extends NetworkTemplateMethodAbstract implements NetworkTemplateMethodStrategyGeneric<File> {

	@Override
	public void validate(File file) throws Exception {
		
		if (file == null) {
			throw new Exception("The parameter: file is required!");
		}
		
		System.out.println("File is valid!");
	}

	@Override
	public void login() throws Exception {
		
		if (getLoginAttributes() == null || getLoginAttributes().isEmpty()) {
			throw new Exception("The parameter: logginAttributes is required!");
		}
		
		System.out.println("Login success!");
	}

	@Override
	public void sendData(File file) throws Exception {
		System.out.println(String.format("File %s successfully sent!", file.getName()));
	}

	@Override
	public void logout() throws Exception {
		
		if (getLoginAttributes() == null || getLoginAttributes().isEmpty()) {
			throw new Exception("The parameter: logginAttributes is required!");
		}
		
		System.out.println("Logout success!");
	}

}
