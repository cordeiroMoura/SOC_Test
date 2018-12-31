package br.com.soc.commons;

import java.util.List;

public class DataSource {
	
	public static List<String> captureNameColumns(String[] tableline, List<String> fieldName) {

		for (int i = 0; i < tableline.length; i++) {

			fieldName.add(tableline[i]);
		}
		return fieldName;
	}
}
