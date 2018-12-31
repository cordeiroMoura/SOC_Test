package br.com.soc.commons;

import java.util.Properties;
import org.openqa.selenium.WebDriver;

public class Browsers {
	
	public static boolean openUrl(WebDriver driver ){
				
		try{
			Properties prop = FileProperties.getProp();
			driver.get(prop.getProperty("url"));	
			
		}catch(Exception e ){
			
			System.out.println(e);
			return false;
		}
		return true;				
	}
}
