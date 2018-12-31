package br.com.soc.commons;

import java.io.IOException;
import java.util.Properties;

import br.com.soc.commons.FileProperties;

public class SelectImageReportSucessFail {
	
	public static String selecImagePassError(String status) throws IOException {

        Properties prop = FileProperties.getProp ();
        String pathImage = null;

        if  (status.equals ("pass")){

            pathImage = prop.getProperty ("sucess");

        }else if (status.equals ("error")){

            pathImage = prop.getProperty ("error");

        }

        return pathImage;
    }
}
