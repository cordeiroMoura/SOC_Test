package br.com.soc.commons;

import java.io.File;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import com.itextpdf.text.Document;

public class ExecutionAction {
	
	 public static boolean executionAction(WebDriver driver, GlobalVar varGlobals, PrintElement prtElement,
             EventType tpEvent, Document doc, File dir2) throws Throwable {
		 
		 if (tpEvent.getIdentifierType().equals ("xpath")) {

	            if (ValidateElementExistence.verifyByXpath (driver, varGlobals.getIdentifier ())) {

	                if (tpEvent.getActionType().equals ("sendKeys")) {
	                    driver.findElement (By.xpath (varGlobals.getIdentifier ())).sendKeys (Keys.chord(varGlobals.getOp2 ()));

	                } else if (tpEvent.getActionType ().equals ("click")) {
	                    driver.findElement (By.xpath (varGlobals.getIdentifier ())).click ();

	                } else if (tpEvent.getActionType ().equals ("select")) {
	                    WebElement element = driver.findElement (By.xpath (varGlobals.getIdentifier ()));
	                    Select select = new Select (element);
	                    select.selectByVisibleText (varGlobals.getOp2 ());
	                }else if (tpEvent.getActionType ().equals ("captureScreen")){

	                    varGlobals.setCaptureText ( driver.findElement (By.xpath (varGlobals.getIdentifier ())).getText ());
	                    varGlobals.setOp2 (varGlobals.getCaptureText ());
	                }
	                ManagerPdf.createParagraphEntry (driver, doc, varGlobals.getOp1 (), varGlobals.getOp2 (), "pass");

	            } else {

	            	ManagerPdf.createParagraphEntry (driver, doc, varGlobals.getOp1 (), varGlobals.getOp2 (), "error");
	                Evidence.evidenceResult (driver, doc, dir2, varGlobals.getMessage (), false);
	                return false;
	            }
	        }

		 //Name		 
		 if (tpEvent.getIdentifierType().equals ("name")) {

	            if (ValidateElementExistence.verifyByName (driver, varGlobals.getIdentifier ())) {

	                if (tpEvent.getActionType().equals ("sendKeys")) {
	                    driver.findElement (By.name (varGlobals.getIdentifier ())).sendKeys (Keys.chord(varGlobals.getOp2 ()));

	                } else if (tpEvent.getActionType ().equals ("click")) {
	                    driver.findElement (By.name (varGlobals.getIdentifier ())).click ();

	                } else if (tpEvent.getActionType ().equals ("select")) {
	                    WebElement element = driver.findElement (By.name (varGlobals.getIdentifier ()));
	                    Select select = new Select (element);
	                    select.selectByVisibleText (varGlobals.getOp2 ());
	                }else if (tpEvent.getActionType ().equals ("captureScreen")){

	                    varGlobals.setCaptureText ( driver.findElement (By.name (varGlobals.getIdentifier ())).getText ());
	                    varGlobals.setOp2 (varGlobals.getCaptureText ());
	                }
	                ManagerPdf.createParagraphEntry (driver, doc, varGlobals.getOp1 (), varGlobals.getOp2 (), "pass");

	            } else {

	            	ManagerPdf.createParagraphEntry (driver, doc, varGlobals.getOp1 (), varGlobals.getOp2 (), "error");
	                Evidence.evidenceResult (driver, doc, dir2, varGlobals.getMessage (), false);
	                return false;
	            }
	        }		 
		 //LInk
		 if (tpEvent.getIdentifierType().equals ("link")) {

	            if (ValidateElementExistence.verifyByLink (driver, varGlobals.getIdentifier ())) {

	                if (tpEvent.getActionType().equals ("sendKeys")) {
	                    driver.findElement (By.linkText (varGlobals.getIdentifier ())).sendKeys (Keys.chord(varGlobals.getOp2 ()));

	                } else if (tpEvent.getActionType ().equals ("click")) {
	                    driver.findElement (By.linkText (varGlobals.getIdentifier ())).click ();

	                } else if (tpEvent.getActionType ().equals ("select")) {
	                    WebElement element = driver.findElement (By.linkText (varGlobals.getIdentifier ()));
	                    Select select = new Select (element);
	                    select.selectByVisibleText (varGlobals.getOp2 ());
	                }else if (tpEvent.getActionType ().equals ("captureScreen")){

	                    varGlobals.setCaptureText ( driver.findElement (By.linkText (varGlobals.getIdentifier ())).getText ());
	                    varGlobals.setOp2 (varGlobals.getCaptureText ());
	                }
	                ManagerPdf.createParagraphEntry (driver, doc, varGlobals.getOp1 (), varGlobals.getOp2 (), "pass");

	            } else {

	            	ManagerPdf.createParagraphEntry (driver, doc, varGlobals.getOp1 (), varGlobals.getOp2 (), "error");
	                Evidence.evidenceResult (driver, doc, dir2, varGlobals.getMessage (), false);
	                return false;
	            }
	        }
		 return true;		 
	 }
}
