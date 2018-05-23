package it.java.mattia.yari.gestoreBollette.model;

import java.sql.SQLException;

import it.java.mattia.yari.gestoreBollette.model.db.DbConnection;

public class TestModel {

	public static void main(String[] args) throws SQLException {
		DbConnection db = DbConnection.getInstance();
		if(db.getConn().isValid(0)) {
			System.out.println("Connesso");
		}
			else {
				System.out.println("non Connesso");
			}

				
		};

}
