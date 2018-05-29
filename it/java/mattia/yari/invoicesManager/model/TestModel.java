package it.java.mattia.yari.invoicesManager.model;



import java.time.LocalDate;
import java.util.List;

import it.java.mattia.yari.invoicesManager.model.beans.Client;
import it.java.mattia.yari.invoicesManager.model.beans.Invoice;
import it.java.mattia.yari.invoicesManager.model.beans.Supplier;
import it.java.mattia.yari.invoicesManager.model.db.ConfigurationProperties;
import it.java.mattia.yari.invoicesManager.model.db.DbConnection;
import it.java.mattia.yari.invoicesManager.model.db.InvoiceDao;


public class TestModel {

	public static void main(String[] args){
		
//		ConfigurationProperties cp = new ConfigurationProperties();
//		System.out.println(cp.getProperty("jdbcUrl"));	    
		DbConnection.getConnection();
		InvoiceDao id = new InvoiceDao();
		List<Invoice> invoice = id.getAll();
		for (Invoice invoice2 : invoice) {
			System.out.println(invoice2);
			
		}
		
		
	}		
		
}
