package br.edu.unibratec.tests.config;

import org.junit.Test;

import br.edu.unibratec.tests.selenium.config.SeleniumConfig;

public class SeleniumConfigTest {
	
	private SeleniumConfig aSeleniumConfig;
	private String aURL = "http://www.baeldung.com/";
	
	@Test
	public void executeSeleniumConfigTest() {
		aSeleniumConfig = new SeleniumConfig();
		aSeleniumConfig.getaWebDriver().get(aURL);
	}
	
}