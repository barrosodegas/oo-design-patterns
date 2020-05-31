package br.com.designPatterns.templateMethod.withStrategyAndGenericsPattern;

public interface NetworkTemplateMethodStrategyGeneric<C> {
	
	default void post(C content) throws Exception {
		validate(content);
		login();
		sendData(content);
		logout();
	}

	public void login() throws Exception;
	
	public void validate(C content) throws Exception;
	
	public void sendData(C content) throws Exception;
	
	public void logout() throws Exception;	
	
}
