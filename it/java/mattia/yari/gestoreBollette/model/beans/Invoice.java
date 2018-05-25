package it.java.mattia.yari.gestoreBollette.model.beans;

import java.awt.image.BufferedImage;
import java.time.LocalDate;



/**
 * @author Yari&Melania
 * 
 */
public class Invoice {
	
	private int ID;
	private String invoiceID ;
	private String supplierName;
	private String clientID;
	private float amount;
	private LocalDate release;
	private LocalDate dueDate;
	private BufferedImage scan;
	private boolean paid;
	
	
	
	
	/*  Getters AND Setters Methods */
	
	
	/* ID  */
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	/*  Invoice ID */
	public String getInvoiceID() {
		return invoiceID;
		
	}
	public boolean setInvoiceID(String invoiceID) {
		if( invoiceID != null ) {
			if(invoiceID.matches("[A-Za-z0-9]{2,}")) {
				this.invoiceID = invoiceID;
				return true;
				}else {
					System.out.println("invalid field 'Invoice ID'. only alphanumeric characters");
					return false;
				}
		}
		else {
			System.out.println("the field 'ente' cannot be empty");
		}
	  return false;
		
	}
	
	/* Supplier Name */
	public String getSupplierName() {
		return supplierName;
	}
	
	public boolean setSupplierName(String supplierName) {
		if( supplierName != null ) {
			if(supplierName.matches("[^\\s'\"]{2,25}")) {
				this.supplierName = supplierName;
				return true;
				}else {
					System.out.println("invalid field 'supplier name'");
					return false;
				}
		}
		else {
			System.out.println("the field 'supplier name' cannot be empty");
		}
	  return false;
	}
	
	
	/* Client ID */
	public String getClientID() {
		return clientID;
	}
	
	public boolean setClientID(String clientID) {
		if( clientID != null ) {
			if(clientID.matches("[A-Za-z0-9]{2,}")) {
				this.clientID = clientID;
				return true;
				}else {
					System.out.println("invalid field 'client ID'");
					return false;
				}
		}
		else {
			System.out.println("the field 'client ID' cannot be empty");
		}
	  return false;
	}
	
	/* Amount  */
	public float getAmount() {
		return amount;
	}
	
	public boolean setAmount(float amount) {
		if(amount > 0) {
			this.amount = amount;
			return true;
		}else {
			System.out.println("amount must be > of 0");
			return false;
		}	
	}
	
	/*  Release */
	public LocalDate getRelease() {
		return release;
	}
	
	public boolean setRelease(LocalDate release) {
		if(release != null) {
				this.release = release;
				return true;
		}else {
			System.out.println("Must insert a valid release date");
			return false;
		}
	}
	
	/*  Due Date */
	public LocalDate getDueDate() {
		return dueDate;
	}
	
	public boolean setDueDate(LocalDate dueDate) {
		if(dueDate != null) {
			if(dueDate.isAfter(this.getRelease()) == false) {
				System.out.println("The due date must be next to release");
				return false;
			}else {
				this.dueDate = dueDate;
				return true;
			}		
	}else {
		System.out.println("Must insert a valid due date");
		return false;
		}
	}
	
	/*  Scan */
	public BufferedImage getScan() {
		return scan;
	}
	public boolean setScan(BufferedImage scan) {
		if( scan != null ) {
			this.scan = scan;
			return true;
			}
			else {
				System.out.println("you need to insert a valid logo image");
			}
		  return false;
	}
	
	/* Paid */
	public boolean isPaid() {
		return paid;
	}
	
	public void setPaid(boolean paid) {
		this.paid = paid;
	}
	
	/* toString */
	@Override
	public String toString() {
		return "Invoice [invoiceID=" + invoiceID + ", supplierName=" + supplierName + ", clientID=" + clientID
				+ ", amount=" + amount + ", release=" + release + ", dueDate=" + dueDate + ", scan=" + scan + ", paid="
				+ paid + "]";
	}
	
	
	
	
	
    
}
	
	
	