package it.java.mattia.yari.gestoreBollette.model.db;

import java.util.List;

public class BolletteDao implements Dao {

	@Override
	public List<Bollette> getAll() {
		// TODO Connessione al Db
		//Select * Tabella
		//return List
		return null;
	}

	@Override
	public Bollette get(String id, String ente) {
		// TODO Connessione al Db
				//Select from Tabella where id = id and ente = ente
				//return Bollette
		return null;
	}

	@Override
	public boolean add(Bollette bolletta) {
		// TODO Connessione al Db
		//Insert into Tabella (id, ente, ...) Values (id, ente, ...)
		//return boolean
		return false;
	}

	@Override
	public boolean update(Bollette bolletta) {
		// TODO Connessione al Db
				//Update Tabella SET (col = val) Where (id, ente)
				//return boolean
		return false;
	}

	@Override
	public boolean delete(Bollette bolletta) {
		// TODO Connessione al Db
		//Delete from Tabella Where (id = id AND ente = ente)
		//return boolean
		return false;
	}


	
}
