package it.java.mattia.yari.gestoreBollette.model;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import it.java.mattia.yari.gestoreBollette.model.db.Bollette;
import it.java.mattia.yari.gestoreBollette.model.db.BolletteDao;
import it.java.mattia.yari.gestoreBollette.model.db.DbConnection;

public class TestModel {

	public static void main(String[] args) throws SQLException {
		DbConnection db = DbConnection.getInstance();
		if(db.getConn().isValid(0)) {
			System.out.println("Connesso");
			BolletteDao bd = new BolletteDao();
			String idFatture = "783140041512535";
			String ente = "Servizio Elettrico nazionale";
			Bollette b = bd.get(idFatture, ente);
			List<Bollette> b1 = bd.getAll();
			Bollette b2 = new Bollette("231324654", "TIM", "1231456", 156.5f, null, null, null, null, false);
			bd.add(b2);
			
				System.out.println(b.getEnte()+" "+b.getNumFattura());
				
				for (Bollette bollette : b1) {
					System.out.println(bollette);
				}
		}
			else {
				System.out.println("non Connesso");
			}

				
		};

}
