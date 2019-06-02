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
		this.aWebDriver  = doInitialWebDriverConfiguration();
	}

	private static WebDriver doInitialWebDriverConfiguration() {
		System.setProperty(WEBDRIVER_CHROME_DRIVER, findDriverPath());
		ChromeOptions chromeOptions = new ChromeOptions();
		
		WebDriver webDriver = new ChromeDriver(chromeOptions);
		
		int timeoutSeconds = 5;
		
		setTimeoutSeconds(webDriver, timeoutSeconds);
		
		return webDriver;
	}
	
	private static void setTimeoutSeconds(WebDriver pWebDriver, int pTimeoutSeconds) {
		pWebDriver.manage().timeouts().implicitlyWait(pTimeoutSeconds, TimeUnit.SECONDS);
	}
	
	private static String findDriverPath() {
		String driverPath = "";
		
		String possiblePaths[] = {
			"",
			"bin/",
			"target/classes/",
			"src/test/resources/"
		};
		
		
		// Looks for the Folder
		/*for ( String pathFolder: possiblePaths ) {
			if ( new File(pathFolder).exists() ) {
				boolean folderExists = true;
			}
		}*/
		
		// Looks for the File itself
		for ( String path: possiblePaths ) {
			String pathFilename = path + CHROME_DRIVER_FILE_NAME;
			if ( new File(pathFilename).exists() ) {
				return pathFilename;
			}
		}
		
		return driverPath;
	}
	
	public static WebDriver getNewWebDriver() {
		return doInitialWebDriverConfiguration();
	}
	
	public WebDriver getWebDriver() {
		return this.aWebDriver;
	}

	public void setaWebDriver(WebDriver aWebDriver) {
		this.aWebDriver = aWebDriver;
	}
	
	public void closeDriver() {
		if ( this.aWebDriver != null ) {
			this.aWebDriver.close();
		}
	}
	
}