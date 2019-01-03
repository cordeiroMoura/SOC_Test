package br.com.soc.commons;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class ManagerFolders {
	
	public static File generateRootFolder(String date, String nameExecution) throws IOException {

		Properties prop = FileProperties.getProp();
		String pathRoot = prop.getProperty("pathRoot");
		File dir = new File(pathRoot + date + nameExecution);
		dir.mkdir();

		return dir;
	}

	public static File generateSubFolders(File dir, int contTestCase, String nameTC) {

		File dir2 = new File(dir + "/" + nameTC + "_00" + contTestCase);
		dir2.mkdir();

		return dir2;
	}
}
