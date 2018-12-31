package br.com.soc.commons;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ValidateElementExistence {
	
	public static boolean verifyByXpath(WebDriver driver, String identifier) throws Throwable
	{
		for (int i = 0; i < 5; i++) {

			try {
				driver.findElement(By.xpath(identifier));

				WebElement element = driver.findElement(By.xpath(identifier));
				new Actions(driver).moveToElement(element).perform();

				return true;
			} catch (Throwable e) {
				Thread.sleep(1000);
				continue;
			}
		}
		return false;
	}
	
	public static boolean verifyByName(WebDriver driver, String identifier) throws Throwable
	{
		for (int i = 0; i < 5; i++) {

			try {
				driver.findElement(By.name(identifier));

				WebElement element = driver.findElement(By.name(identifier));
				new Actions(driver).moveToElement(element).perform();

				return true;
			} catch (Throwable e) {
				Thread.sleep(1000);
				continue;
			}
		}
		return false;
	}	
	
	public static boolean verifyByLink(WebDriver driver, String identifier) throws Throwable

	{
		for (int i = 0; i < 5; i++) {

			try {
				driver.findElement(By.linkText(identifier));

				WebElement element = driver.findElement(By.linkText(identifier));
				new Actions(driver).moveToElement(element).perform();

				return true;
			} catch (Throwable e) {
				Thread.sleep(1000);
				continue;
			}
		}
		return false;
	}

}
