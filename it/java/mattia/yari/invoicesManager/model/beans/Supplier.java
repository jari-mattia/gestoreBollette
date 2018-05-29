package it.java.mattia.yari.invoicesManager.model.beans;

import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.List;

public class Supplier {

	private long ID;
	private String supplierName;
	private BufferedImage logo;
	private URL www;
	private String mail;
	private String Phone;
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

	
	/*  The Web Site Url for this Supplier */
	public URL getWww() {
		return www;
	}

	public void setWww(URL www) {
		this.www = www;
	}
	
	/*  a valid mail address for contact this supplier */
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	/* a phone number for this supplier */
	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
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
	
	/*  toString */
	@Override
	public String toString() {
		return "Supplier [ID=" + ID + ", supplierName=" + supplierName + ", logo=" + logo + ", www=" + www + ", mail="
				+ mail + ", Phone=" + Phone + ", invoices=" + invoices + ", clients=" + clients + "]";
	}

	@Override
	
	/* hashCode */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (ID ^ (ID >>> 32));
		result = prime * result + ((Phone == null) ? 0 : Phone.hashCode());
		result = prime * result + ((clients == null) ? 0 : clients.hashCode());
		result = prime * result + ((invoices == null) ? 0 : invoices.hashCode());
		result = prime * result + ((logo == null) ? 0 : logo.hashCode());
		result = prime * result + ((mail == null) ? 0 : mail.hashCode());
		result = prime * result + ((supplierName == null) ? 0 : supplierName.hashCode());
		result = prime * result + ((www == null) ? 0 : www.hashCode());
		return result;
	}

	@Override
	
	/* equals */
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
		if (Phone == null) {
			if (other.Phone != null)
				return false;
		} else if (!Phone.equals(other.Phone))
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
		if (mail == null) {
			if (other.mail != null)
				return false;
		} else if (!mail.equals(other.mail))
			return false;
		if (supplierName == null) {
			if (other.supplierName != null)
				return false;
		} else if (!supplierName.equals(other.supplierName))
			return false;
		if (www == null) {
			if (other.www != null)
				return false;
		} else if (!www.equals(other.www))
			return false;
		return true;
	}
	
	
	

	
	
	
	
	
	
	
	
	
}