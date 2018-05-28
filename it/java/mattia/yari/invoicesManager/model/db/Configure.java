package it.java.mattia.yari.invoicesManager.model.db;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configure extends Properties{

	private static final long serialVersionUID = 1L;
	private InputStream is;
	
	public Configure(File file) {
		try {
			is = new FileInputStream(file);
			this.load(is);
			is.close();
		}catch(FileNotFoundException e) {
			e.getMessage();
		} 
		catch (IOException e) {
			e.getMessage();
		}
	}

}
