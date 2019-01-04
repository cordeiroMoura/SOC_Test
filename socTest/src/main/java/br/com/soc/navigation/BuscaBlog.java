package br.com.soc.navigation;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import br.com.soc.commons.ActionsValues;
import br.com.soc.commons.DefineAction;
import br.com.soc.commons.EventType;
import br.com.soc.commons.Evidence;
import br.com.soc.commons.ExecutionAction;
import br.com.soc.commons.GlobalVar;
import br.com.soc.commons.ManagerPdf;
import br.com.soc.commons.NavigationVariable;
import br.com.soc.commons.PrintElement;
import br.com.soc.commons.SetGlobalVariables;
import br.com.soc.runner.Manager;

public class BuscaBlog {
	
	public static boolean buscarBlog(WebDriver driver, GlobalVar varGlobals, PrintElement prntElement,
			SetGlobalVariables varsManager, EventType tpEvent, NavigationVariable navVar) throws Throwable {

		String[] variables = navVar.getVariables();

		/*********************************************************************************/

		ManagerPdf.tableTitlePage(driver, varsManager.getDocPDF());
		ManagerPdf.createParagraphEntry(driver, varsManager.getDocPDF(), "System Fields:", "", "");

		/*********************************************************************************/

		// Click no input de Busca do Blog 

		ActionsValues.atributtesActions(varGlobals, "//*[@id=\"blog\"]/div/div[1]/div/form/input[3]", "Selecionou o input", "Click", "",
				"Falha ao clicar no botao " + varGlobals.getOp1());

		DefineAction.defineAction(tpEvent, "xpath", "click");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;		
		
		/*********************************************************************************/
		
		if (variables[3] != null) {
		// Preenche palavra para buscar
		ActionsValues.atributtesActions(varGlobals, "//*[@id=\"blog\"]/div/div[1]/div/form/input[3]", "Buscar por: ", variables[3], "",
				"Falha ao preencher o campo " + varGlobals.getOp1());
		DefineAction.defineAction(tpEvent, "xpath", "sendKeys");
		
		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;	
		}
		
		// Teste click bot�o limpar
		if (variables[3] == null){				
		
		driver.findElement(By.xpath("//*[@id=\"blog\"]/div/div[1]/div/form/input[3]")).sendKeys("Teste");
		
		ActionsValues.atributtesActions(varGlobals, "//section[@id='blog']/div/div/div/form/input[3]", "Click bot�o limpar", "Click", "",
				"Falha ao clicar no bot�o " + varGlobals.getOp1());
		
		DefineAction.defineAction(tpEvent, "xpath", "click");
									
		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;	
		}
		
		/*********************************************************************************/
		
		// Pesquisar palavra para buscar

		ActionsValues.atributtesActions(varGlobals, "//*[@id=\"blog\"]/div/div[1]/div/form/input[1]", "Click na lupa", "Click", "",
				"Falha ao clicar no bot�o " + varGlobals.getOp1());

				DefineAction.defineAction(tpEvent, "xpath", "click");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == false)
			return false;
				

		/*********************************************************************************/	

				
		// Evid�ncia - Resultado busca
				
				Thread.sleep(2000);

		ActionsValues.atributtesActions(varGlobals, "//*[@id=\"blog\"]/div/div[1]/div", "Mensagem: ",
						varGlobals.getCaptureText(), "", "Falha ao capturar Texto: " + varGlobals.getOp1());

				DefineAction.defineAction(tpEvent, "xpath", "captureScreen");

		if (ExecutionAction.executionAction(driver, varGlobals, prntElement, tpEvent, varsManager.getDocPDF(),
				varsManager.getDir2()) == true) {

					ManagerPdf.tableTitlePage(driver, varsManager.getDocPDF());
					varsManager.setMessage("Mensagem ");
					Evidence.evidenceResult(driver, varsManager.getDocPDF(), varsManager.getDir2(), varsManager.getMessage(),
							
							false);					
		}
		
		
		return true;
	}
}
