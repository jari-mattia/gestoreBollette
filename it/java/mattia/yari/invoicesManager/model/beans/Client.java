package it.java.mattia.yari.invoicesManager.model.beans;

import java.util.List;

public class Client {

	int ID;
	String clientID;
	private String name;
	private String lastName;
	private List<Invoice> invoices;
	
	
	/* Getter and Setter  */
	
	/*  ID read-only from DB */
	public int getID() {
		return ID;
	}
	
	/* Client ID from Invoice */
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


	public String getName() {
		return name;
	}

	public boolean setName(String name) {
		
		if(name != null) {
			/* min 2, max 25 char, can include '-', but not twice consecutively, must start and finish with an alphabetic letter */
			if(name.matches("(?i)(^[a-z])([a-z]*[-]?[a-z]+)*{2,25}$")) {
				this.name = name;
				return true;
				}else{
					System.out.println("'name' must be min 2 and max 25 characters; it can include '-', but not twice consecutively and must start and finish with an alphabetic letter");
					return false;
				}
			
		}else{
			System.out.println("the field 'name' cannot be empty");
			return false;
			}
	}
	


	public String getLastName() {
		return lastName;
	}


	public boolean setLastName(String lastName) {
		
		if(lastName != null) {
			/* min 2, max 25 char, can include '-', but not twice consecutively, must start and finish with an alphabetic letter */
			if(lastName.matches("(?i)(^[a-z])([a-z]*[-]?[a-z]+)*{2,25}$")) {
				this.lastName = lastName;
				return true;
				}else{
					System.out.println("'lastName' must be min 2 and max 25 characters; it can include '-', but not twice consecutively and must start and finish with an alphabetic letter");
					return false;
				}
			
		}else{
			System.out.println("the field 'lastName' cannot be empty");
			return false;
			}
		}

	/* list of invoices for this client */
	public List<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(List<Invoice> invoices) {
		this.invoices = invoices;
	}

	
	/* INHERETIED METHODS */
	
	
	@Override
	/*  hashcode */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + ((clientID == null) ? 0 : clientID.hashCode());
		result = prime * result + ((invoices == null) ? 0 : invoices.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Client other = (Client) obj;
		if (ID != other.ID)
			return false;
		if (clientID == null) {
			if (other.clientID != null)
				return false;
		} else if (!clientID.equals(other.clientID))
			return false;
		if (invoices == null) {
			if (other.invoices != null)
				return false;
		} else if (!invoices.equals(other.invoices))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	/* toString */
	public String toString() {
		return "Client [ID=" + ID + ", clientID=" + clientID + ", name=" + name + ", lastName=" + lastName
				+ ", invoices=" + invoices.toString() + "]";
	}

	
	

	
	
}