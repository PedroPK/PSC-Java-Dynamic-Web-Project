package br.edu.unibratec.tests.selenium.config;

import org.junit.Test;

public class Selenium_MWA_Cadastro {
	
	private SeleniumConfig aSeleniumConfig;
	private String aURL = "http://localhost:8080/MWA/Cadastro";
	
	@Test
	public void executeSeleniumConfigTest() {
		aSeleniumConfig = new SeleniumConfig();
		aSeleniumConfig.getWebDriver().get(aURL);
		aSeleniumConfig.closeDriver();
	}
	
}