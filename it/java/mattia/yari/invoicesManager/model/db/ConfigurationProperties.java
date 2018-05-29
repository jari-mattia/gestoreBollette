package it.java.mattia.yari.invoicesManager.model.db;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationProperties extends Properties{

	/**
	 * a read-only class wrapper for config.properties file 
	 */
	private static final long serialVersionUID = 1L;
	
	public ConfigurationProperties() {
		super();
		FileInputStream is;
		try {
			is = new FileInputStream("../gestoreBollette/lib/config.properties");
			this.load(is);
		} catch (FileNotFoundException e) {
			System.out.println("Configuration file not found in /lib folder");
			e.getMessage();
		} catch (IOException e) {
			System.out.println("error to load config file");
			e.getMessage();
		}
		
	}
}
