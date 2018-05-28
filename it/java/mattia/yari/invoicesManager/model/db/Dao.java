package it.java.mattia.yari.invoicesManager.model.db;

import java.util.List;

import it.java.mattia.yari.invoicesManager.model.beans.Invoice;

public interface Dao {

	public  List<Invoice> getAll();
	public  Invoice get(String invoiceID, String supplierName);
	public  boolean add(Invoice invoice);
	public  boolean update(Invoice invoice);
	public  boolean delete(Invoice invoice);
}
