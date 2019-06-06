package br.edu.unibratec.tests.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.edu.unibratec.tests.selenium.config.SeleniumConfigTest;

@RunWith(Suite.class)
@SuiteClasses(
	{
		Selenium_MWA_CadastroServlet.class,
		SeleniumConfigTest.class
	}
)
public class AllSeleniumTests {

}
