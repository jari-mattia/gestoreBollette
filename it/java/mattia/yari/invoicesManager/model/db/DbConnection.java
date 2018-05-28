package it.java.mattia.yari.invoicesManager.model.db;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

	
	private Connection conn;
	private File file = new File("../GestoreBollette/lib/conf.properties");
	private static DbConnection dbConn;
	private Configure conf = new Configure(file); 
	private String url = conf.getProperty("url");
	
	private DbConnection(){
		try {
		conn = DriverManager.getConnection(url, conf);
		}
		catch(SQLException ex) {
			    System.out.println("SQLException: " + ex.getMessage());
			    System.out.println("SQLState: " + ex.getSQLState());
			    System.out.println("VendorError: " + ex.getErrorCode());
			}
	}
	
public static DbConnection getInstance() {
	if(dbConn == null) {
		dbConn = new DbConnection();
		}
		return dbConn;
	}

public Connection getConn() {
	return conn;
}


}
	
	
