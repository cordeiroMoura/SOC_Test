package br.com.soc.commons;

import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SelectBrowsers {
	
public static WebDriver startChromeDriver(WebDriver driver) throws IOException{
		
		Properties prop = FileProperties.getProp();
		String caminhoChromeDriver = prop.getProperty("chromedriverSoc");
				
		System.setProperty("webdriver.chrome.driver", caminhoChromeDriver );
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		
		return driver;
	}

}
