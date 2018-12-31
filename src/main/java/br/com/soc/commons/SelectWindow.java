package br.com.soc.commons;

import org.openqa.selenium.WebDriver;

public class SelectWindow {
	
	 public static void selectWindowAtual(WebDriver driver) {

	        @SuppressWarnings("unused")
	        String paginaInicial = driver.getWindowHandle();
	       // Perform the click operation that opens new window
           // Switch to new window opened
	        for (String janelasAbertas : driver.getWindowHandles()) {
	            driver.switchTo().window(janelasAbertas);
	        }
	       //driver.switchTo().window(paginaInicial)
	    }
}
