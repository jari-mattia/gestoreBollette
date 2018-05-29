package it.java.mattia.yari.invoicesManager.model;



import java.time.LocalDate;

import it.java.mattia.yari.invoicesManager.model.beans.Client;
import it.java.mattia.yari.invoicesManager.model.beans.Invoice;
import it.java.mattia.yari.invoicesManager.model.beans.Supplier;


public class TestModel {

	public static void main(String[] args){
		
		Client client = new Client();
		client.setClientID("324563");
		
		Supplier supplier = new Supplier();
		supplier.setSupplierName("ENEL");
		
		Invoice invoice = new Invoice();
		invoice.setInvoiceID("8989789DSDD");
		invoice.setClientID(client);
		invoice.setSupplierName(supplier);
		invoice.setRelease(LocalDate.of(2017, 8, 24));
		invoice.setDueDate(LocalDate.of(2018, 9, 20));
		invoice.setAmount(34.5f);
		invoice.setScan(null);
		invoice.setPaid(false);
		
		System.out.println(invoice);
	}
}
