package br.com.soc.commons;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;

public class Evidence {
	
	public static void evidenceResult(WebDriver driver, Document doc, File dir2, String message, boolean condidition)
			throws DocumentException, IOException, AWTException, InterruptedException {

		String pathEvidence;

		if (condidition) {

			ManagerPdf.tableTitlePage(driver, doc);

			pathEvidence = CaptureScreen.capturePage(dir2, message);			
		
			ManagerPdf.addReportImage(driver, doc, pathEvidence, message);

		} else {

			pathEvidence = CaptureScreen.capturePage(dir2, message);

			ManagerPdf.addReportImage(driver, doc, pathEvidence, message);
		}

	}

}
