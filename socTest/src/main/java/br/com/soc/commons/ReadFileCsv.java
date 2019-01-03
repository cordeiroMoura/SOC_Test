package br.com.soc.commons;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import com.opencsv.CSVReader;

import br.com.soc.commons.FileProperties;

public class ReadFileCsv {
	
	@SuppressWarnings("deprecation")
	public static CSVReader readFileCSV() throws IOException{

        Properties prop = FileProperties.getProp();
        String filedate = prop.getProperty("filedateUPLOAD");

        CSVReader reader = new CSVReader(new FileReader(
                filedate), ';');

        return reader;
    }
}
