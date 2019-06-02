package br.edu.unibratec.tests.selenium.config;

import org.junit.Test;

public class SeleniumConfigTest {
	
	private SeleniumConfig aSeleniumConfig;
	private String aURL = "http://www.baeldung.com/";
	
	@Test
	public void executeSeleniumConfigTest() {
		aSeleniumConfig = new SeleniumConfig();
		aSeleniumConfig.getaWebDriver().get(aURL);
		aSeleniumConfig.closeDriver();
	}
	
}