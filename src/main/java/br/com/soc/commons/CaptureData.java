package br.com.soc.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import org.openqa.selenium.WebDriver;

public class CaptureData {
	
	public static String captureNowData() throws InterruptedException{
			
		DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd hh:mm:ss");
		Date date = new Date();

		System.out.println("Start .......");
		Thread.sleep(1000);
		System.out.println("Date Run: " + dateFormat.format(date)); 
		// 2014/08/06	15:59:48
		DateFormat dateFormat2 = new SimpleDateFormat("yyyy_MM_dd_hh_mm");
		Date date2 = new Date();
		return dateFormat2.format(date2);		
	}
	
	public static String nameRandomExecution() {
		
		StringBuilder geraNum = new StringBuilder();
		String words = "ABCDEFGHIJKLMNOPQRSTUVYWXZ";
		
		Random random = new Random();
		String storeKeys = "";
		int index =-1;
		
		for (int i =0; i<5; i++){
			
			index = random.nextInt(words.length());
			storeKeys+=words.substring(index, index+1);
		}		
		geraNum.append(("_"+storeKeys));
		
		return geraNum.toString();		
	}
}
