package it.java.mattia.yari.gestoreBollette.model.db;

import java.util.List;

public interface Dao {

	public List<Bollette> getAll();
	public Bollette get(String id, String ente);
	public boolean add(Bollette bolletta);
	public boolean update(Bollette bolletta);
	public boolean delete(Bollette bolletta);
}
