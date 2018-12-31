package br.com.soc.commons;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;

public class SetGlobalVariables {
	
	boolean firstLine;
	boolean returnExecution;
	int numberColumns;
	int countTestCase;
	int pdfNumberColumns;
	int totalCaseTestPass, totalCaseTestFail;
	int contPass;
	int contFail;
	int contadorSessao;
	String expectedResults;
	String[] tableline;
	String pathSaveScreenShoot;
	String message;
	String nameTC;
	String TextodaTabela;
	File dir2;
	List<String> fieldsName = new ArrayList<String>();
	Document docPDF;

	public boolean isFirstLine() {
		return firstLine;
	}

	public void setFirstLine(boolean firstLine) {
		this.firstLine = firstLine;
	}

	public boolean isReturnExecution() {
		return returnExecution;
	}

	public void setReturnExecution(boolean returnExecution) {
		this.returnExecution = returnExecution;
	}

	public int getNumberColumns() {
		return numberColumns;
	}

	public void setNumberColumns(int numberColumns) {
		this.numberColumns = numberColumns;
	}

	public int getCountTestCase() {
		return countTestCase;
	}

	public void setCountTestCase(int countTestCase) {
		this.countTestCase = countTestCase;
	}

	public int getPdfNumberColumns() {
		return pdfNumberColumns;
	}

	public void setPdfNumberColumns(int pdfNumberColumns) {
		this.pdfNumberColumns = pdfNumberColumns;
	}

	public int getTotalCaseTestPass() {
		return totalCaseTestPass;
	}

	public void setTotalCaseTestPass(int totalCaseTestPass) {
		this.totalCaseTestPass = totalCaseTestPass;
	}

	public int getTotalCaseTestFail() {
		return totalCaseTestFail;
	}

	public void setTotalCaseTestFail(int totalCaseTestFail) {
		this.totalCaseTestFail = totalCaseTestFail;
	}

	public int getContPass() {
		return contPass;
	}

	public void setContPass(int contPass) {
		this.contPass = contPass;
	}

	public int getContFail() {
		return contFail;
	}

	public void setContFail(int contFail) {
		this.contFail = contFail;
	}

	public int getContadorSessao() {
		return contadorSessao;
	}

	public void setContadorSessao(int contadorSessao) {
		this.contadorSessao = contadorSessao;
	}

	public String getExpectedResults() {
		return expectedResults;
	}

	public void setExpectedResults(String expectedResults) {
		this.expectedResults = expectedResults;
	}

	public String[] getTableline() {
		return tableline;
	}

	public void setTableline(String[] tableline) {
		this.tableline = tableline;
	}

	public String getPathSaveScreenShoot() {
		return pathSaveScreenShoot;
	}

	public void setPathSaveScreenShoot(String pathSaveScreenShoot) {
		this.pathSaveScreenShoot = pathSaveScreenShoot;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getNameTC() {
		return nameTC;
	}

	public void setNameTC(String nameTC) {
		this.nameTC = nameTC;
	}

	public String getTextodaTabela() {
		return TextodaTabela;
	}

	public void setTextodaTabela(String textodaTabela) {
		TextodaTabela = textodaTabela;
	}

	public File getDir2() {
		return dir2;
	}

	public void setDir2(File dir2) {
		this.dir2 = dir2;
	}

	public List<String> getFieldsName() {
		return fieldsName;
	}

	public void setFieldsName(List<String> fieldsName) {
		this.fieldsName = fieldsName;
	}

	public Document getDocPDF() {
		return docPDF;
	}

	public void setDocPDF(Document docPDF) {
		this.docPDF = docPDF;
	}

}
