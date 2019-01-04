package br.com.soc.runner;

import java.io.File;

import javax.print.Doc;

import org.openqa.selenium.WebDriver;
import com.opencsv.CSVReader;
import com.itextpdf.*;
import br.com.soc.commons.Browsers;
import br.com.soc.commons.DataSource;
import br.com.soc.commons.EventType;
import br.com.soc.commons.GlobalVar;
import br.com.soc.commons.ManagerFolders;
import br.com.soc.commons.ManagerPdf;
import br.com.soc.commons.NavigationVariable;
import br.com.soc.commons.PrintElement;
import br.com.soc.commons.ReadFileCsv;
import br.com.soc.commons.SelectBrowsers;
import br.com.soc.commons.SetGlobalVariables;
import br.com.soc.navigation.BuscaBlog;

public class Manager {
	
	public static void managerExecution(WebDriver driver, File dir, String date) throws Throwable {

		SetGlobalVariables gblv = new SetGlobalVariables();

		gblv.setFirstLine(true);
		gblv.setReturnExecution(true);
		gblv.setNumberColumns(0);
		gblv.setCountTestCase(1);
		gblv.setPdfNumberColumns(0);
		gblv.setTotalCaseTestPass(0);
		gblv.setTotalCaseTestFail(0);
		gblv.setTableline(null);

		String[] tableline = null;
		System.out.print(gblv.isFirstLine());

		CSVReader reader = ReadFileCsv.readFileCSV();

		NavigationVariable navVar = new NavigationVariable();

		while ((tableline = reader.readNext()) != null) {

			navVar.setVariables(tableline);

			gblv.setNumberColumns(tableline.length);

			gblv.setFieldsName(DataSource.captureNameColumns(tableline, gblv.getFieldsName()));

			if (gblv.isFirstLine()) {

				gblv.setFirstLine(false);
				continue;
			}

			driver = SelectBrowsers.startChromeDriver(driver);

			gblv.setReturnExecution(Browsers.openUrl(driver));
			gblv.setDir2(ManagerFolders.generateSubFolders(dir, gblv.getCountTestCase(), tableline[0]));
			gblv.setDocPDF(ManagerPdf.generatePdf(gblv.getDir2()));

			ManagerPdf.addHeaderFilePdf(gblv.getDocPDF(), "");

			ManagerPdf.insertDescriptionExecution(gblv.getDocPDF(), navVar);

			GlobalVar varGlobal = new GlobalVar();
			PrintElement prinElem = new PrintElement();
			EventType evenTyp = new EventType();

			@SuppressWarnings("unused")
			String[] variables = navVar.getVariables();

			if (gblv.isReturnExecution()) {

				gblv.setReturnExecution(
						BuscaBlog.buscarBlog(driver, varGlobal, prinElem, gblv, evenTyp, navVar));
				System.out.println(gblv.isReturnExecution());
				gblv.getDocPDF().close();				
			}
			
			Thread.sleep(1500);
			
			driver.close();
			
		}
	}
}
