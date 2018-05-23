package it.java.mattia.yari.gestoreBollette.model.db;

import java.awt.image.BufferedImage;
import java.util.Date;


public class Bollette {

	private String numFattura;
	private String ente;
	private String codCliente;
	private float importo;
	private Date emissione;
	private Date scadenza;
	private BufferedImage logo ;
	
	
	public Bollette() {
	}


	public Bollette(String numFattura, String ente) {
		this.numFattura = numFattura;
		this.ente = ente;
	}


	public Bollette(String numFattura, String ente, float importo, Date scadenza) {
		this.numFattura = numFattura;
		this.ente = ente;
		this.importo = importo;
		this.scadenza = scadenza;
	}


	public Bollette(String numFattura, String ente, String codCliente, float importo, Date emissione, Date scadenza,
			BufferedImage logo) {
		this.numFattura = numFattura;
		this.ente = ente;
		this.codCliente = codCliente;
		this.importo = importo;
		this.emissione = emissione;
		this.scadenza = scadenza;
		this.logo = logo;
	}


	public String getNumFattura() {
		return numFattura;
	}


	public void setNumFattura(String numFattura) {
		this.numFattura = numFattura;
	}


	public String getEnte() {
		return ente;
	}


	public void setEnte(String ente) {
		this.ente = ente;
	}


	public String getCodCliente() {
		return codCliente;
	}


	public void setCodCliente(String codCliente) {
		this.codCliente = codCliente;
	}


	public float getImporto() {
		return importo;
	}


	public void setImporto(float importo) {
		this.importo = importo;
	}


	public Date getEmissione() {
		return emissione;
	}


	public void setEmissione(Date emissione) {
		this.emissione = emissione;
	}


	public Date getScadenza() {
		return scadenza;
	}


	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}


	public BufferedImage getLogo() {
		return logo;
	}


	public void setLogo(BufferedImage logo) {
		this.logo = logo;
	}
	
	
}
