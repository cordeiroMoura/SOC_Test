package br.com.soc.navigation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import br.com.soc.commons.ActionsValues;
import br.com.soc.commons.DefineAction;
import br.com.soc.commons.EventType;
import br.com.soc.commons.Evidence;
import br.com.soc.commons.ExecutionAction;
import br.com.soc.commons.Generators;
import br.com.soc.commons.GlobalVar;
import br.com.soc.commons.ManagerPdf;
import br.com.soc.commons.NavigationVariable;
import br.com.soc.commons.PrintElement;
import br.com.soc.commons.SetGlobalVariables;

public class BuscaBlog {
	
	public static boolean buscarBlog(WebDriver driver, GlobalVar varGlobals, PrintElement prntElement,
			SetGlobalVariables varsManager, EventType tpEvent, NavigationVariable navVar) throws Throwable {

		String[] variables = navVar.getVariables();

		/*********************************************************************************/

		ManagerPdf.tableTitlePage(driver, varsManager.getDocPDF());
		ManagerPdf.createParagraphEntry(driver, varsManager.getDocPDF(), "System Fields:", "", "");

		/*********************************************************************************/

		// 

		ActionsValues.atributtesActions(varGlobals, "//*[@id=\"cover\"]/div[3]/div[2]/a[2]", "Cadastre se", "Click", "",
				"Falha ao clicar no botao " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "click");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		ManagerPdf.tableTitlePage(driver, varsManager.getDocPDF());
		ManagerPdf.createParagraphEntry(driver, varsManager.getDocPDF(), "System Fields:", "", "");

		/*********************************************************************************/

		// 

		if (variables[3].equals("")) {

			variables[3] = Generators.generateNames();
		}

		ActionsValues.atributtesActions(varGlobals, "name", "Nome", variables[3], "",
				"Falha ao preencher o campo " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "name", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		if (variables[4].equals("")) {
			variables[4] = Generators.generateSurnames();
		}

		/*********************************************************************************/

		// 

		ActionsValues.atributtesActions(varGlobals, "surname", "Sobre Nome", variables[4], "",
				"Falha ao preencher o campo " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "name", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		if (variables[5].equals("")) {

			variables[5] = Generators.geradorCPF();
		}

		ActionsValues.atributtesActions(varGlobals,
				"//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[2]/div[1]/input", "CPF",
				variables[5], "", "Falha ao preencher o campo " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		if (variables[6].equals("masculino")) {

			ActionsValues.atributtesActions(varGlobals,
					"//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[2]/div[2]/label[2]/input",
					"Sexo", variables[6], "", "Falha ao escolher sexo " + varGlobals.getOp1());
		} else if (variables[6].equals("feminino")) {
			ActionsValues.atributtesActions(varGlobals,
					"//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[2]/div[2]/label[3]/input",
					"Sexo", variables[6], "", "Falha ao escolher sexo " + varGlobals.getOp1());

		}

		DefineAction.defineAction(tpEvent, "xpath", "click");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		ActionsValues.atributtesActions(varGlobals, "birthdate", "Data de Nascimento", variables[7], "",
				"Falha ao preencher o campo " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "name", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		ActionsValues.atributtesActions(varGlobals, "number", "Telefone", variables[8], "",
				"Falha ao preencher o campo " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "name", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		if (variables[9].equals("")) {

			variables[9] = Generators.generateEmail();
		}

		ActionsValues.atributtesActions(varGlobals, "email", "E-mail", variables[9], "",
				"Falha ao preencher o campo " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "name", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		try {
			driver.findElement(By.xpath("//div[@id='state']/div/span/i")).click();
		} catch (Exception e) {

			varGlobals.setMessage("Falha ao clicar no combo Estado");

		}
		int contadorEstado = 3;
		boolean resp = false;
		String verifyUf;

		while (resp == false) {

			verifyUf = driver.findElement(By.xpath("//div[" + contadorEstado + "]/span/div")).getText();

			if (verifyUf.equals(variables[10])) {
				resp = true;
			} else {
				contadorEstado++;
			}
		}

		ActionsValues.atributtesActions(varGlobals, "//div[" + contadorEstado + "]/span/div", "Estado", variables[10], "",
				"Falha no preenchimento: " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "click");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		
		/*********************************************************************************/

		// 

		Thread.sleep(1000);
		
		try {
			driver.findElement(By.xpath("//*[@id=\"city\"]/div[1]/span/span[1]")).click();
		} catch (Exception e) {
			varGlobals.setMessage("Falha ao clicar no combo Cidade");
		}

		int contadorCidade = 3;
		boolean resp1 = false;
		String verifyCity;

		while (resp1 == false) {

			verifyCity = driver.findElement(By.xpath("//div[" + contadorCidade + "]/span/div")).getText();

			if (verifyCity.equals(variables[11])) {
				resp1 = true;
			} else {
				contadorCidade++;
			}
		}

		ActionsValues.atributtesActions(varGlobals, "//div[" + contadorCidade + "]/span/div", "Cidade", variables[11], "",
				"Falha no preenchimento: " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "click");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		ActionsValues.atributtesActions(varGlobals,
				"//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[5]/div[1]/input", "Senha",
				variables[12], "", "Falha ao criar senha " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		if (variables[12].equals(variables[13])) {

			ActionsValues.atributtesActions(varGlobals,
					"//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[5]/div[2]/input",
					"Confirma Senha", variables[13], "", "Falha ao Confirmar Senha" + varGlobals.getOp1());
		}
		DefineAction.defineAction(tpEvent, "xpath", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		// 

		String resp2 = "//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[6]/label/input";

		if (resp2 == " ") {
			driver.findElement(By.xpath(resp2)).click();
		}
		ActionsValues.atributtesActions(varGlobals, resp2, "Cadastro Termos de Uso", "Selecionado", "",
				"Selecionar termos de uso " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		//

		String resp3 = "//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[7]/div/label/input";
		if (resp3 == "") {
			driver.findElement(By.xpath(resp3)).isDisplayed();
		}
		ActionsValues.atributtesActions(varGlobals, resp2, "Cadastro Mooba", "Selecionado", "",
				"Não Selecionado" + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "sendKeys");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		//

		ActionsValues.atributtesActions(varGlobals,
				"//*[@id=\"pages-signin-signup\"]/div/div/div[1]/div/div/div[2]/form/div[8]/button", "Cadastrar", "Ok",
				"", "Cadastrar " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "click");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;

		/*********************************************************************************/

		//

		Thread.sleep(3000);

		ActionsValues.atributtesActions(varGlobals, "//*[@id=\"pages-signin-signup\"]/div/div/div[1]/h1", "Mensagem:",
				varGlobals.getCaptureText(), "", "Falha ao capturar Texto: " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "captureScreen");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == true) {

			ManagerPdf.tableTitlePage(driver, varsManager.getDocPDF());
			varsManager.setMessage("Usuario cadastrado com sucesso");
			Evidence.evidenceResult(driver, varsManager.getDocPDF(), varsManager.getDir2(), varsManager.getMessage(),
					false);

			// SelectWindown.selectWindowAtual(driver);
		}
		return true;
	}
}
