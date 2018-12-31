package br.com.soc.commons;

public class ConfigDesktop {
	
	public static void machineDataExecution (){
		
		String userLogin, so, osVersion, osArch;
		so = System.getProperty("os.name").toLowerCase();
		osVersion = System.getProperty("os.version").toLowerCase();
		System.out.println( "Available Processors " +  Runtime.getRuntime().availableProcessors());	
	}
}
