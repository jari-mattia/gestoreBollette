package it.java.mattia.yari.gestoreBollette.model.beans;

import java.awt.image.BufferedImage;

public class Supplier {

	private long ID;
	private String supplierName;
	private BufferedImage logo;
	

	/* Getter and setter method */
	
	public String getSupplierName() {
		return supplierName;
	}


	public void setSupplierName(Invoice i) {
		this.supplierName = i.getSupplierName();
	}


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


	public long getID() {
		return ID;
	}

}