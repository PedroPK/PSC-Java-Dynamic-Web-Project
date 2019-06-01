package br.edu.unibratec.tests.selenium.config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SeleniumConfig {
	
	private WebDriver aWebDriver;
	
	private static final String CHROME_DRIVER_FILE_NAME = "chromedriver";
	private static final String WEBDRIVER_CHROME_DRIVER		= "webdriver.chrome.driver";
	private static final String WEBDRIVER_FIREFOX_DRIVER	= "webdriver.gecko.driver";
	
	public SeleniumConfig() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, findDriverPath());
		ChromeOptions chromeOptions = new ChromeOptions();
		
		this.aWebDriver = new ChromeDriver(chromeOptions);
		
		int timeoutSeconds = 5;
		
		setTimeoutSeconds(timeoutSeconds);
	}
	
	private void setTimeoutSeconds(int pTimeoutSeconds) {
		this.aWebDriver.manage().timeouts().implicitlyWait(pTimeoutSeconds, TimeUnit.SECONDS);
	}
	
	private String findDriverPath() {
		String driverPath = "";
		
		String possiblePaths[] = {
			"",
			"bin/",
			"target/classes",
			"src/test/resources"
		};
		
		for ( String path: possiblePaths ) {
			String pathFilename = path + CHROME_DRIVER_FILE_NAME;
			if ( new File(pathFilename).exists() ) {
				return pathFilename;
			}
		}
		
		return driverPath;
	}

	public WebDriver getaWebDriver() {
		return aWebDriver;
	}

	public void setaWebDriver(WebDriver aWebDriver) {
		this.aWebDriver = aWebDriver;
	}
	
}