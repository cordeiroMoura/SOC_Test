package br.com.soc.commons;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.DottedLineSeparator;

public class ManagerPdf {
	
	public static Document generatePdf(File dir2) throws FileNotFoundException, DocumentException {

		Document doc = new Document(PageSize.A4);

		OutputStream os = new FileOutputStream(dir2 + "/" + "relatorioTeste.pdf");
		PdfWriter.getInstance(doc, os);
		doc.open();
		
		return doc;
	}

	public static void addHeaderFilePdf(Document doc, String nameTestCase)
			throws IOException, InterruptedException, DocumentException {

		Properties prop = FileProperties.getProp();

		Font boldFont = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);

		Font changeFont = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
		changeFont.setColor(BaseColor.BLUE);

		Font normal = new Font(Font.FontFamily.COURIER, 12, Font.BOLD);
		normal.setColor(BaseColor.BLUE);

		// Define a quantidade colunas cabeçalho
		PdfPTable tableHeader = new PdfPTable(new float[] { 0.17f, 0.31f, 0.15f, 0.37f });

		PdfPCell header = new PdfPCell(new Paragraph("Teste Automação - SOC Soft. Integ. de Gestão Ocupacional",
				changeFont));
		header.setUseBorderPadding(true);
		header.setBorderColor(BaseColor.BLUE);
		header.setHorizontalAlignment(Element.ALIGN_CENTER);
		header.setColspan(4);

		tableHeader.setSpacingBefore(20);
		tableHeader.addCell(header);

		PdfPCell lblSystem = new PdfPCell(new Paragraph("Aplicação", normal));
		PdfPCell txtSystem = new PdfPCell(new Paragraph(prop.getProperty("nomeAplicacao")));

		PdfPCell lblVersion = new PdfPCell(new Paragraph("Versao", normal));
		PdfPCell txtVersion = new PdfPCell(new Paragraph("V1", boldFont));
		//PdfPCell lblCT = new PdfPCell(new Paragraph("CT", normal));
		//PdfPCell txtCT = new PdfPCell(new Paragraph("nomeCT", normal));
		PdfPCell lblExecutor = new PdfPCell(new Paragraph("Executor", normal));
		PdfPCell txtExecutor = new PdfPCell(new Paragraph(System.getProperty("user.name")));
		PdfPCell lblData = new PdfPCell(new Paragraph("Data", normal));
		PdfPCell txtData = new PdfPCell(new Paragraph(CaptureData.captureNowData()));

		PdfPCell lblBrowser = new PdfPCell(new Paragraph("Browser", normal));
		PdfPCell txtBrowser = new PdfPCell(new Paragraph(prop.getProperty("browser")));

		PdfPCell lblSO = new PdfPCell(new Paragraph("Sistema", normal));
		PdfPCell txtSO = new PdfPCell(new Paragraph(System.getProperty("os.name")));

		PdfPCell lblbuild = new PdfPCell(new Paragraph("Build", normal));
		PdfPCell txtbuild = new PdfPCell(new Paragraph(prop.getProperty("Build")));

		PdfPCell lblambiente = new PdfPCell(new Paragraph("Ambiente", normal));
		PdfPCell txtambiente = new PdfPCell(new Paragraph(prop.getProperty("Ambiente")));

		lblSystem.setBorderColor(BaseColor.BLUE);
		lblSystem.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSystem.setBorderColor(BaseColor.BLUE);

		lblVersion.setBorderColor(BaseColor.BLUE);
		lblVersion.setHorizontalAlignment(Element.ALIGN_TOP);
		txtVersion.setBorderColor(BaseColor.BLUE);

		//lblCT.setBorderColor(BaseColor.BLUE);
		//lblCT.setHorizontalAlignment(Element.ALIGN_TOP);
		//txtCT.setBorderColor(BaseColor.BLUE);

		lblExecutor.setBorderColor(BaseColor.BLUE);
		lblExecutor.setHorizontalAlignment(Element.ALIGN_TOP);
		txtExecutor.setBorderColor(BaseColor.BLUE);

		lblData.setBorderColor(BaseColor.BLUE);
		lblData.setHorizontalAlignment(Element.ALIGN_TOP);
		txtData.setBorderColor(BaseColor.BLUE);

		lblSO.setBorderColor(BaseColor.BLUE);
		lblSO.setHorizontalAlignment(Element.ALIGN_TOP);
		txtSO.setBorderColor(BaseColor.BLUE);

		lblBrowser.setBorderColor(BaseColor.BLUE);
		lblBrowser.setHorizontalAlignment(Element.ALIGN_TOP);
		txtBrowser.setBorderColor(BaseColor.BLUE);

		lblbuild.setBorderColor(BaseColor.BLUE);
		lblbuild.setHorizontalAlignment(Element.ALIGN_TOP);
		txtbuild.setBorderColor(BaseColor.BLUE);

		lblambiente.setBorderColor(BaseColor.BLUE);
		lblambiente.setHorizontalAlignment(Element.ALIGN_TOP);
		txtambiente.setBorderColor(BaseColor.BLUE);

		tableHeader.addCell(lblSystem);
		tableHeader.addCell(txtSystem);
		tableHeader.addCell(lblVersion);
		tableHeader.addCell(txtVersion);
		// tableheader.addCell(lblCT);
		// tableheader.addCell(txtCT);
		tableHeader.addCell(lblExecutor);
		tableHeader.addCell(txtExecutor);
		tableHeader.addCell(lblData);
		tableHeader.addCell(txtData);
		tableHeader.addCell(lblSO);
		tableHeader.addCell(txtSO);
		tableHeader.addCell(lblBrowser);
		tableHeader.addCell(txtBrowser);
		tableHeader.addCell(lblambiente);
		tableHeader.addCell(txtambiente);
		tableHeader.addCell(lblbuild);
		tableHeader.addCell(txtbuild);

		tableHeader.setSpacingAfter(30);
		doc.add(tableHeader);

	}

	public static void insertDescriptionExecution(Document doc, NavigationVariable navVar) throws DocumentException {

		String variables[] = navVar.getVariables();

		Font changeFontlbl = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		Font changeFonttxt = new Font(Font.FontFamily.TIMES_ROMAN, 10);

		Paragraph lblFieldrequirements = new Paragraph("Requirements : ", changeFontlbl);
		Paragraph txtFieldrequirements = new Paragraph(variables[0], changeFonttxt);

		Paragraph lblFieldtarget = new Paragraph("Target Test : ", changeFontlbl);
		Paragraph txtFieldtarget = new Paragraph(variables[1], changeFonttxt);

		Paragraph lblFieldnameTest = new Paragraph("Name Test Case : ", changeFontlbl);
		Paragraph txtFieldnameTest = new Paragraph(variables[2], changeFonttxt);

		DottedLineSeparator dottedLine = new DottedLineSeparator();
		dottedLine.setLineColor(BaseColor.BLUE);

		lblFieldrequirements.setSpacingAfter(5);
		txtFieldrequirements.setSpacingAfter(5);

		lblFieldtarget.setSpacingAfter(5);
		txtFieldtarget.setSpacingAfter(5);

		lblFieldnameTest.setSpacingAfter(5);
		txtFieldnameTest.setSpacingAfter(5);

		dottedLine.setOffset(-2);
		dottedLine.setGap(1f);
		lblFieldrequirements.add(dottedLine);

		lblFieldtarget.add(dottedLine);
		lblFieldnameTest.add(dottedLine);

		txtFieldnameTest.setSpacingAfter(45);

		doc.add(lblFieldrequirements);
		doc.add(txtFieldrequirements);

		doc.add(lblFieldtarget);
		doc.add(txtFieldtarget);

		doc.add(lblFieldnameTest);
		doc.add(txtFieldnameTest);

	}

	public static void tableTitlePage(WebDriver driver, Document doc) throws DocumentException {

		String titlePage = driver.getTitle();
		String url = driver.getCurrentUrl();

		if (titlePage.equals("")) {

			titlePage = "Esta página não comtém título.";
		}
		Font changeSourceDataEntered = new Font(Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);

		Paragraph descriptionPage = new Paragraph("Título da página: " + titlePage, changeSourceDataEntered);
		Paragraph descriptionURL = new Paragraph("URL: " + url, changeSourceDataEntered);

		descriptionURL.setSpacingAfter(20);
		doc.add(descriptionPage);
		doc.add(descriptionURL);

	}	

	public static void createParagraphEntry(WebDriver driver, Document doc, String fieldName, String inputValue, String status ) throws IOException, DocumentException{
		
		 PdfPCell cell = null, cell2 = null, cell3 = null;

	        Font textBold = new Font (Font.FontFamily.TIMES_ROMAN, 10, Font.BOLD);
	        Font text = new Font (Font.FontFamily.TIMES_ROMAN, 8);

	        Font normal = new Font (Font.FontFamily.COURIER, 12, Font.BOLD);
	        normal.setColor (BaseColor.BLUE);

	        Font normal2 = new Font (Font.FontFamily.COURIER, 10, Font.BOLD);
	        normal2.setColor (BaseColor.BLUE);

	        PdfPTable tableInputs = new PdfPTable (new float[]{0.40f, 0.40f, 0.20f});
	        tableInputs.setWidthPercentage (100);
	        tableInputs.setHorizontalAlignment (Element.ALIGN_LEFT);


	        if (fieldName.equals ("System Fields:")) {

	            cell = new PdfPCell (new Paragraph (fieldName, normal));
	            cell.setBackgroundColor (BaseColor.GRAY);
	            cell.setColspan (1);
	            cell.setBorderColor (BaseColor.BLUE);
	            tableInputs.addCell (cell);

	            cell2 = new PdfPCell (new Paragraph ("Input Values", normal));
	            cell2.setBackgroundColor (BaseColor.GRAY);
	            cell2.setColspan (1);
	            cell2.setBorderColor (BaseColor.BLUE);
	            tableInputs.addCell (cell2);

	            cell3 = new PdfPCell (new Paragraph ("Status", normal2));
	            cell3.setBackgroundColor (BaseColor.GRAY);
	            cell3.setColspan (1);
	            cell3.setBorderColor (BaseColor.BLUE);
	            tableInputs.addCell (cell3);

	        } else {

	            cell = new PdfPCell (new Paragraph (fieldName, textBold));
	            cell2 = new PdfPCell (new Paragraph (inputValue, text));

	            cell.setBorderColor (BaseColor.BLUE);
	            cell2.setBorderColor (BaseColor.BLUE);

	            // s verify status test
	            String choiseImg = SelectImageReportSucessFail.selecImagePassError (status);
	            // e

	            Image img = Image.getInstance (choiseImg);
	            img.setAlignment (Element.ALIGN_CENTER);
	            img.scalePercent (70);

	            PdfPCell img3 = new PdfPCell ();
	            img3.addElement (new Chunk (img, 10, 0));

	            img3.setBorderColor (BaseColor.BLUE);

	            tableInputs.addCell (cell);
	            tableInputs.addCell (cell2);
	            tableInputs.addCell (img3);

	        }

	        doc.add (tableInputs);		
		
	}	
	
	public static void addReportImage(WebDriver driver, Document doc, String pathEvidence, String subtitle) throws IOException, DocumentException, InterruptedException {

        Font changeSubtitleImage = new Font (Font.FontFamily.TIMES_ROMAN, 8, Font.BOLD);

        PdfPTable tableImage = new PdfPTable (new float[]{0.100f});
        tableImage.setHorizontalAlignment (Element.ALIGN_CENTER);

        PdfPCell subtitlecell = new PdfPCell (new Paragraph (subtitle, changeSubtitleImage));
        subtitlecell.setHorizontalAlignment (Element.ALIGN_CENTER);
        subtitlecell.setBorderColor (BaseColor.BLUE);

        tableImage.setSpacingBefore (20);

        Image img = Image.getInstance (pathEvidence);
        img.setAlignment (Element.ALIGN_CENTER);
        PdfPCell img2 = new PdfPCell (img, true);
        img2.setBorderColor (BaseColor.BLUE);

        tableImage.addCell (img2);

        tableImage.addCell (subtitlecell);

        doc.add (tableImage);
        
        doc.newPage ();

        ManagerPdf.addHeaderFilePdf(doc, "");
        doc.close();
    }		
}
