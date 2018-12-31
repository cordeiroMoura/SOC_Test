package br.com.soc.commons;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileProperties {
	
	public static Properties getProp() throws IOException {
		
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream("C:\\Meu Robo SOC\\configRobo.properties");
		prop.load(file);
				
		return prop;
	}
}
