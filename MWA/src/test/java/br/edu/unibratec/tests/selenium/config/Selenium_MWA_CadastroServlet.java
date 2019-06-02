package br.edu.unibratec.tests.selenium.config;

import static br.edu.unibratec.tests.selenium.utils.SeleniumWebElementsHandler.fillInputValue;
import static br.edu.unibratec.tests.selenium.utils.SeleniumWebElementsHandler.getElementById;
import static br.edu.unibratec.tests.selenium.utils.SeleniumWebElementsHandler.getInputValue;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Selenium_MWA_CadastroServlet {
	
	private static final String ID_INPUT_TEXT_NAME	= "nome";
	private static final String ID_INPUT_TEXT_CPF	 = "cpf";
	
	private static			WebDriver		aWebDriver;
	private static final	String			URL = "http://localhost:8080/MWA/Cadastro";
	
	@BeforeClass
	public static void executeSeleniumConfigTest() {
		aWebDriver = SeleniumConfig.getNewWebDriver();
		aWebDriver.get(URL);
	}
	
	@Test
	public void findNameField() {
		// Arrange
		String id = ID_INPUT_TEXT_NAME;
		WebElement fieldName = getElementById(aWebDriver, id);
		
		//Assert
		assertNotNull(fieldName);
	}
	
	@Test
	public void fillFieldName() {
		// Arrange
		String id = ID_INPUT_TEXT_NAME;
		WebElement fieldName = getElementById(aWebDriver, id);
		
		// Act
		String previousText = fieldName.getText();
		String text = "My name is SlimShade";
		
		fillInputValue(aWebDriver, id, text);
		
		String newText = getInputValue(fieldName);
		
		//Assert
		assertNotNull(fieldName);
		assertNotNull(previousText);
		assertNotEquals(previousText, newText);
	}
	
	@Test
	public void fillFieldCPF_withoutDotsAndHyphens() {
		// Arrange
		String id = ID_INPUT_TEXT_CPF;
		WebElement fieldCpf = getElementById(aWebDriver, id);
		
		// Act
		String previousText = fieldCpf.getText();
		
		/*
		 *  If we use Dots and Hyphens, 
		 *  and the Input type is Number, 
		 *  it do not fill the Value attribute
		 */
		String text = "12345678901";
		
		fillInputValue(fieldCpf, text);
		
		String newText = getInputValue(fieldCpf);
		
		//Assert
		assertNotNull(fieldCpf);
		assertNotNull(previousText);
		assertNotEquals(previousText, newText);
	}
	
	@Test
	public void fillFieldCPF_withtDotsAndHyphens() {
		// Arrange
		String id = ID_INPUT_TEXT_CPF;
		WebElement fieldCpf = getElementById(aWebDriver, id);
		
		// Act
		String previousText = fieldCpf.getText();
		
		/*
		 *  If we use Dots and Hyphens, 
		 *  and the Input type is Text instead of Number, 
		 *  it will fill the Value attribute
		 */
		String text = "123.456.789-01";
		
		fillInputValue(fieldCpf, text);
		
		String newText = getInputValue(fieldCpf);
		
		//Assert
		assertNotNull(fieldCpf);
		assertNotNull(previousText);
		assertNotEquals(previousText, newText);
	}
	
	@AfterClass
	public static void closeDriver() {
		aWebDriver.close();
	}
	
}