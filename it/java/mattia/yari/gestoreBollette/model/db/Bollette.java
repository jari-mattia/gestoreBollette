package it.java.mattia.yari.gestoreBollette.model.db;

import java.awt.image.BufferedImage;
import java.time.LocalDate;
import java.util.Date;


/**
 * @author Yari&Melania
 *
 */
public class Bollette {

	private String numFattura;
	private String ente;
	private String codCliente = null;
	private float importo = 0;
	private LocalDate emissione = null;
	private LocalDate scadenza = null;
	private BufferedImage logo = null;
	private BufferedImage scan = null;
	private boolean pagata = false;
	
	
	/*
	 * Constructors
	 * */
	
	public Bollette() {
	}


	public Bollette(String numFattura, String ente, String codCliente, float importo, LocalDate emissione,
			LocalDate scadenza, BufferedImage logo, BufferedImage scan, boolean pagata) {
		this.numFattura = numFattura;
		this.ente = ente;
		this.codCliente = codCliente;
		this.importo = importo;
		this.emissione = emissione;
		this.scadenza = scadenza;
		this.logo = logo;
		this.scan = scan;
		this.pagata = pagata;
	}


	
	/*
	 * Getter & Setter
	 * */

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


	public LocalDate getEmissione() {
		return emissione;
	}


	public void setEmissione(LocalDate emissione) {
		this.emissione = emissione;
	}


	public LocalDate getScadenza() {
		return scadenza;
	}


	public void setScadenza(LocalDate scadenza) {
		this.scadenza = scadenza;
	}


	public BufferedImage getLogo() {
		return logo;
	}


	public void setLogo(BufferedImage logo) {
		this.logo = logo;
	}


	public BufferedImage getScan() {
		return scan;
	}


	public void setScan(BufferedImage scan) {
		this.scan = scan;
	}


	public boolean isPagata() {
		return pagata;
	}


	public void setPagata(boolean pagata) {
		this.pagata = pagata;
	}


	@Override
	public String toString() {
		return "Bollette [numFattura=" + numFattura + ", ente=" + ente + ", codCliente=" + codCliente + ", importo="
				+ importo + ", emissione=" + emissione + ", scadenza=" + scadenza + ", logo=" + logo + ", scan=" + scan
				+ ", pagata=" + pagata + ", getNumFattura()=" + getNumFattura() + ", getEnte()=" + getEnte()
				+ ", getCodCliente()=" + getCodCliente() + ", getImporto()=" + getImporto() + ", getEmissione()="
				+ getEmissione() + ", getScadenza()=" + getScadenza() + ", getLogo()=" + getLogo() + ", getScan()="
				+ getScan() + ", isPagata()=" + isPagata() + ", toString()=" + super.toString() + "]";
	}
	
	

	/*
	 * toString
	 * */
	
	
	
	
}
