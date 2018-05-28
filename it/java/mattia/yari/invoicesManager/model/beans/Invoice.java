package it.java.mattia.yari.invoicesManager.model.beans;

import java.io.InputStream;
import java.time.LocalDate;



/**
 * @author Yari Mattia
 * 
 */
public class Invoice {
	
	private int ID;
	private String invoiceID ;
	private Supplier supplier;
	private Client client;
	private float amount;
	private LocalDate release;
	private LocalDate dueDate;
	private LocalDate referencePeriodStart;
	private LocalDate referencePeriodEnd;
	private InputStream scan;
	private boolean paid;
	
	
	
	/* CONSTRUCTOR */
	public Invoice() {
	}


	/*  GETTER & SETTER METHODS */
	
	
	/* ID read-only from DB  */
	public int getID() {
		return ID;
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
	public Supplier getSupplierName() {
		return supplier;
	}
	
	public boolean setSupplierName(Supplier supplier) {
		if(supplier != null) {
			this.supplier = supplier;
			return true;
			}else {
				System.out.println("there is a supplier associated to this invoice");
				return false;
			}
	}
	
	
	/* Client ID */
	public Client getClient() {
		return client;
	}
	
	public boolean setClientID(Client client) {
		if(client != null) {
			this.client = client;
			return true;
		}else {
			System.out.println("there is a supplier associated to this invoice");
			return false;
		}
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
	
	/*  Reference period start */
	public LocalDate getReferencePeriodStart() {
		return referencePeriodStart;
	}
	
	public boolean setReferencePeriodStart(LocalDate referencePeriodStart) {
		if(referencePeriodStart != null) {
				this.referencePeriodStart = referencePeriodStart;
				return true;
		}else {
			System.out.println("Must insert a valid reference start date");
			return false;
		}
	}
	
	/* Reference period end */
	public LocalDate getReferencePeriodEnd() {
		return referencePeriodEnd;
	}
	
	public boolean setReferencePeriodEnd(LocalDate referencePeriodEnd) {
		if(referencePeriodEnd != null) {
			if(referencePeriodEnd.isAfter(this.getRelease()) == false) {
				System.out.println("The reference date end must be next to reference end date");
				return false;
			}else {
				this.referencePeriodEnd = referencePeriodEnd;
				return true;
			}		
	}else {
		System.out.println("Must insert a valid due date");
		return false;
		}
	}
	
	
	/*  Scan */
	public InputStream getScan() {
		return scan;
	}
	public boolean setScan(InputStream scan) {
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
	
	
	/* INHERETIED METHODS */
	
	/* toString */
	@Override
	public String toString() {
		return "Invoice [ID=" + ID + ", invoiceID=" + invoiceID + ", supplier=" + supplier.getSupplierName() + ", client=" + client.getClientID()
				+ ", amount=" + amount + ", release=" + release + ", dueDate=" + dueDate + ", referencePeriodStart="
				+ referencePeriodStart + ", referencePeriodEnd=" + referencePeriodEnd + ", scan=" + scan + ", paid="
				+ paid + "]";
	}

	/* hashCode */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + Float.floatToIntBits(amount);
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + ((invoiceID == null) ? 0 : invoiceID.hashCode());
		result = prime * result + (paid ? 1231 : 1237);
		result = prime * result + ((referencePeriodEnd == null) ? 0 : referencePeriodEnd.hashCode());
		result = prime * result + ((referencePeriodStart == null) ? 0 : referencePeriodStart.hashCode());
		result = prime * result + ((release == null) ? 0 : release.hashCode());
		result = prime * result + ((scan == null) ? 0 : scan.hashCode());
		result = prime * result + ((supplier == null) ? 0 : supplier.hashCode());
		return result;
	}

	/*  equals */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (ID != other.ID)
			return false;
		if (Float.floatToIntBits(amount) != Float.floatToIntBits(other.amount))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (invoiceID == null) {
			if (other.invoiceID != null)
				return false;
		} else if (!invoiceID.equals(other.invoiceID))
			return false;
		if (paid != other.paid)
			return false;
		if (referencePeriodEnd == null) {
			if (other.referencePeriodEnd != null)
				return false;
		} else if (!referencePeriodEnd.equals(other.referencePeriodEnd))
			return false;
		if (referencePeriodStart == null) {
			if (other.referencePeriodStart != null)
				return false;
		} else if (!referencePeriodStart.equals(other.referencePeriodStart))
			return false;
		if (release == null) {
			if (other.release != null)
				return false;
		} else if (!release.equals(other.release))
			return false;
		if (scan == null) {
			if (other.scan != null)
				return false;
		} else if (!scan.equals(other.scan))
			return false;
		if (supplier == null) {
			if (other.supplier != null)
				return false;
		} else if (!supplier.equals(other.supplier))
			return false;
		return true;
	}
	    
}
	
	
	