package br.edu.unibratec.tests.selenium.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SeleniumWebElementsHandler {
	
	private static final String ATTRIBUTE_VALUE = "value";

	public static WebElement getElementById(WebDriver pWebDriver, String pId) {
		return pWebDriver.findElement(By.id(pId));
	}
	
	public static String getInputValue(WebElement pWebElement) {
		return pWebElement.getAttribute(ATTRIBUTE_VALUE);
	}
	
	public static void fillInputValue(WebElement pWebElement, String pValue) {
		pWebElement.sendKeys(pValue);
	}
}