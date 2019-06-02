package br.edu.unibratec.tests.selenium.utils;

import static br.edu.unibratec.tests.selenium.utils.SeleniumWebElementsHandler.getElementById;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import br.edu.unibratec.psc.util.UtilMethods;

public class SeleniumWebElementsHandler {
	
	private		WebDriver	aWebDriver;
	
	private static final String ATTRIBUTE_VALUE = "value";
	
	/**
	 * This method will look for a WebElement in the WebDriver by an Id
	 * 
	 * @param pWebDriver	WebDriver from where to find the WebElement
	 * @param pId			The ID that will be used to find the WebElement
	 * 
	 * @return				The desired WebElement
	 */
	public static WebElement getElementById(WebDriver pWebDriver, String pId) {
		WebElement response = null;
		
		if ( pWebDriver != null && UtilMethods.isStringValid(pId) ) {
			response = pWebDriver.findElement(By.id(pId));
		}
		
		return response;
	}
	
	/**
	 * This method will look for a WebElement in the WebDriver attribute (if it is not null(,
	 * by an Id
	 * 
	 * @param 		pId			The ID that will be used to find the WebElement
	 * 
	 * @return		WebElement	The desired WebElement
	 */
	public WebElement getElementById(String pId) {
		WebElement response = null;
		
		if ( this.aWebDriver != null ) {
			response = getElementById(this.aWebDriver, pId);
		}
		
		return response;
	}
	
	/**
	 * This method will get the Text Content in que Value attribute of the WebElement parameter
	 * 
	 * @param		pWebElement		WebElement that will be used to extract the Text Content of Value attribute
	 * 
	 * 	@return		String			Text Content of Value attribute
	 */
	public static String getInputValue(WebElement pWebElement) {
		return pWebElement.getAttribute(ATTRIBUTE_VALUE);
	}
	
	/**
	 * This method will fill the Input content, specifically the Value attribute
	 * 
	 * @param pWebElement	WebElement that should receive the Text
	 * @param pValue		The Text that will be used to fill the WebElement
	 */
	public static void fillInputValue(WebElement pWebElement, String pValue) {
		pWebElement.sendKeys(pValue);
	}
	
	public void fillInputValue(WebElement pFieldName, String pId, String pText) {
		WebElement field = getElementById(this.aWebDriver, pId);
		fillInputValue(pFieldName, pText);
	}
	
	public void fillInputValue(String pId, String pText) {
		fillInputValue(getElementById(this.aWebDriver, pId), pText);
	}
	
	public static void fillInputValue(WebDriver pWebDriver, String pId, String pText) {
		fillInputValue(getElementById(pWebDriver, pId), pText);
	}
	
}