package it.java.mattia.yari.gestoreBollette.model.db;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;



public class BolletteDao implements Dao {

	@Override
	public List<Bollette> getAll() {
		List<Bollette>result = new ArrayList<Bollette>(); 
		DbConnection db = DbConnection.getInstance();
		try {
			if(db.getConn().isValid(0)) {
				String sql = "SELECT * FROM bollette";
				PreparedStatement ps = db.getConn().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					/*ResultSetMetaData rsmd = rs.getMetaData();
					for (int i = 0; i <= rsmd.getColumnCount(); i++) {
						String col = rsmd.getColumnName(i);}*/
					
					Blob blob = rs.getBlob(6);
					BufferedImage image = blobToBufferedImage(blob);
					
					
					
					Bollette b = new Bollette(rs.getString(0),
											  rs.getString(1),
											  rs.getString(2),
											  rs.getFloat(3),
											  rs.getDate(4),
											  rs.getDate(5),
											  image);
					result.add(b);
					
				}
				db.getConn().close();
				return result;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Bollette get(String numFattura, String ente) {
		DbConnection db = DbConnection.getInstance();
		String sql = "SELECT FROM bollette WHERE num_fattura = ? AND ente = ?";
		try {
			PreparedStatement ps = db.getConn().prepareStatement(sql);
			ps.setString(1, numFattura);
			ps.setString(2, ente);
			ResultSet rs = ps.executeQuery();
			
			Blob blob = rs.getBlob(6);
			BufferedImage image = blobToBufferedImage(blob);
			Bollette bolletta = new Bollette(rs.getString(0),
					  rs.getString(1),
					  rs.getString(2),
					  rs.getFloat(3),
					  rs.getDate(4),
					  rs.getDate(5),
					  image);
			db.getConn().close();
			return bolletta;
			
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
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


	private BufferedImage blobToBufferedImage(Blob blob) {
		try {
		InputStream in = blob.getBinaryStream();  
		BufferedImage image = ImageIO.read(in);
		return image;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			e.getMessage();
		}
		return null;
	}
}
