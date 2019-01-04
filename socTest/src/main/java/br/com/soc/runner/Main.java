package br.com.soc.runner;

import java.io.File;
import com.itextpdf.*;
import org.openqa.selenium.WebDriver;
import br.com.soc.commons.CaptureData;
import br.com.soc.commons.ConfigDesktop;
import br.com.soc.commons.ManagerFolders;
import br.com.soc.commons.ManagerPdf;
import br.com.soc.runner.Manager;

public class Main {
	
	static WebDriver driver;

	public static void main(String[] args)  throws Throwable {
			
			String date, nameExecution;
			File dir;

			ConfigDesktop.machineDataExecution();

			date = CaptureData.captureNowData();

			nameExecution = CaptureData.nameRandomExecution();

			dir = ManagerFolders.generateRootFolder(date, nameExecution);			
			
			Manager.managerExecution(driver, dir, date);					
	}
}
