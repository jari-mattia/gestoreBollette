package it.java.mattia.yari.gestoreBollette.model.beans;

import java.awt.image.BufferedImage;
import java.util.List;

public class Supplier {

	private long ID;
	private String supplierName;
	private BufferedImage logo;
	private List<Invoice> invoices;
	private List<Client> clients;
	

	/* Getter and setter method */
	
	/* read-only ID from DB */
	public long getID() {
		return ID;
	}

	/*  name of this supplier */
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


	/* logo of this supplier */
	public BufferedImage getLogo() {
		return logo;
	}


	public boolean setLogo(BufferedImage logo) {
		
		if( logo != null ) {
			this.logo = logo;
			return true;
			}
			else {
				System.out.println("you need to insert a valid logo image");
			}
		  return false;
		}

	/* list of invoices for this supplier */
	public List<Invoice> getInvoices() {
		return invoices;
	}


	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

		
		/* list of clients of this supplier */
	public List<Client> getClients() {
		return clients;
	}


	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	
	/* INHERETIED METHODS */

	@Override
	/*hashcode*/
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
		result = prime * result + ((invoices == null) ? 0 : invoices.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		return result;
	}

	
	@Override
	/*equals*/
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Supplier other = (Supplier) obj;
		if (ID != other.ID)
			return false;
		if (clients == null) {
			if (other.clients != null)
				return false;
		} else if (!clients.equals(other.clients))
			return false;
		if (invoices == null) {
			if (other.invoices != null)
				return false;
		} else if (!invoices.equals(other.invoices))
			return false;
		if (logo == null) {
			if (other.logo != null)
				return false;
		} else if (!logo.equals(other.logo))
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		return true;
	}

	@Override
	/* toString */
	public String toString() {
		return "Supplier [ID=" + ID + ", supplierName=" + supplierName + ", logo=" + logo + ", invoices=" + invoices.toString()
				+ ", clients=" + clients.toString() + "]";
	}

	
	
	
	
	
	
	
	
}