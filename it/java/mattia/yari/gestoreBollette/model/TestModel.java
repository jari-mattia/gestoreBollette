package it.java.mattia.yari.gestoreBollette.model;



import java.time.LocalDate;

import it.java.mattia.yari.gestoreBollette.model.beans.Invoice;


public class TestModel {

	public static void main(String[] args){
		Invoice invoice = new Invoice();
		invoice.setInvoiceID("8989789DSDD");
		invoice.setClientID("2ddfgf");
		invoice.setSupplierName("Enel");
		invoice.setRelease(LocalDate.of(2017, 8, 24));
		invoice.setDueDate(LocalDate.of(2018, 9, 20));
		invoice.setAmount(34.5f);
		invoice.setScan(null);
		invoice.setPaid(false);
		
		System.out.println(invoice);
	}
}
