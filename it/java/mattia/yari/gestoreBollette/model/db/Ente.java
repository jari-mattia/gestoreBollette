package it.java.mattia.yari.gestoreBollette.model.db;

import java.awt.image.BufferedImage;

public class Ente {

	private long id;
	private String nomeEnte;
	private BufferedImage logo;
	
	/* if Ente data is in input from view , it will no have an ID code */
	public Ente(String nomeEnte, BufferedImage logo) {
		this.nomeEnte = nomeEnte;
		this.logo = logo;
	}

	
	/* if Ente data is in output from database , it will have an auto-generated ID code */
	public Ente(long id, String nomeEnte, BufferedImage logo) {
		
		this.id = id;
		this.nomeEnte = nomeEnte;
		this.logo = logo;
	}

	/* Getter and setter method */
	
	public String getNomeEnte() {
		return nomeEnte;
	}


	public boolean setNomeEnte(String nomeEnte) {
		if( nomeEnte != null ) {
			if(nomeEnte.matches("[. [^\\s'\"]]{2,25}")) {
				this.nomeEnte = nomeEnte;
				return true;
				}else {
					System.out.println("invalid field ente");
					return false;
				}
		}
		else {
			System.out.println("the field 'ente' cannot be empty");
		}
	  return false;
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


	public long getId() {
		return id;
	}
}