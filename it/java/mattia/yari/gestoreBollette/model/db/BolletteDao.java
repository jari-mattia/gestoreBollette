package it.java.mattia.yari.gestoreBollette.model.db;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
//import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;



public class BolletteDao implements Dao {

	@Override
	
	public List<Bollette> getAll() {
		List<Bollette>result = new ArrayList<Bollette>(); 
		DbConnection db = DbConnection.getInstance();
		String sql = "SELECT * FROM bollette";
		try {
				PreparedStatement ps = db.getConn().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Bollette b = filterOutput(rs);
					result.add(b);
					
				db.getConn().close();
				return result;
				
			}
		} catch (SQLException e) {
			e.getMessage();
			
		}
		return null;
	  }

	@Override
	public Bollette get(String numFattura, String ente) {
		Bollette bolletta = new Bollette();
		DbConnection db = DbConnection.getInstance();
		String sql = "SELECT * FROM bollette WHERE id_fatture = ? AND ente = ?";
		try {
			PreparedStatement ps = db.getConn().prepareStatement(sql);
			ps.setString(1, numFattura);
			ps.setString(2, ente);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Bollette b = filterOutput(rs);
				bolletta = b;
			}
			db.getConn().close();
			return bolletta;
			
		} catch (SQLException e) {
			e.getMessage();
			
		}
		return null;
	}

	@Override
	public boolean add(Bollette b) {
		DbConnection db = DbConnection.getInstance();
		String sql = "INSERT INTO bollette (id_fatture, ente, cod_cliente, importo, emissione, scadenza, logo, scan, pagata) VALUES (?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = db.getConn().prepareStatement(sql);
			if(filterInput(b, ps))
				System.out.println("Add riuscito");
				return true;
			
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
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
			e.printStackTrace();
			return null;
		}catch (SQLException e) {
			e.getMessage();
		}
		return null;
	}
	
	private InputStream bufferedImageToBlob(BufferedImage bi) {
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		try {
			ImageIO.write(bi, "png", baos);
		} catch (IOException e) {
			e.getMessage();
		}
		InputStream is = new ByteArrayInputStream(baos.toByteArray());
		
		return is;		
	}
	
	private Bollette filterOutput(ResultSet rs) {
		
		Bollette b = new Bollette();
		
			try {
			  if((rs.getString(1) != null) && (rs.getString(2) != null)) {
				  b.setNumFattura(rs.getString(1));
				  b.setEnte(rs.getString(2));
				  }
			  }catch(NullPointerException e) {
				  e.getMessage();
			  }catch(SQLException e) {
				  e.getMessage();
			  }
			
			try {
				  if(rs.getString(3) != null) {
					  b.setCodCliente(rs.getString(3));
					  }
				  }catch(SQLException e) {
					  e.getMessage();
				  }
			
			try {
				  b.setImporto(rs.getFloat(4));
			}catch(SQLException e) {
				  e.getMessage();
			  }
			
			try {
				 LocalDate emissione;
				 Date sqlEmissione = rs.getDate(5);
				 if(sqlEmissione != null) {
					emissione = sqlEmissione.toLocalDate();
					b.setEmissione(emissione);
				 }
				  
			}catch(SQLException e) {
				  e.getMessage();
			  }
			  
			try {
				 LocalDate scadenza;
				 Date sqlScadenza = rs.getDate(6);
				 if(sqlScadenza != null) {
					scadenza = sqlScadenza.toLocalDate();
					b.setScadenza(scadenza);
				 }
				  
			}catch(SQLException e) {
				  e.getMessage();
			  }
			
			
			try {
				Blob blob = rs.getBlob(7);
				if(blob != null) {
				BufferedImage image = blobToBufferedImage(blob);
				b.setLogo(image);
				}
			} catch (SQLException e) {
				e.getMessage();
			} 
			
			try {
				Blob blob = rs.getBlob(8);
				if(blob != null) {
				BufferedImage scan = blobToBufferedImage(blob);
				b.setScan(scan);
				}
			} catch (SQLException e) {
				e.getMessage();
			} 
			
			try {
				boolean pagata = rs.getBoolean(9);
				b.setPagata(pagata);
				
			} catch (SQLException e) {
				e.getMessage();
			}
			
		return b;
		
	}
	
	private boolean filterInput(Bollette b, PreparedStatement ps) throws SQLException {
		try {
			if(b.getNumFattura() != null && b.getEnte() != null) {
				ps.setString(1, b.getNumFattura());
				ps.setString(2, b.getEnte());
				}
			
		} catch (NullPointerException e) {
			e.getMessage();
			return false;
			}
		ps.setString(3, b.getCodCliente());
		ps.setFloat(4, b.getImporto());
		
		LocalDate em = b.getEmissione();
		Date emissione = Date.valueOf(em);
		ps.setDate(5, emissione);
		
		LocalDate sc = b.getEmissione();
		Date scadenza = Date.valueOf(sc);
		ps.setDate(6, scadenza);
		
		InputStream isLogo = bufferedImageToBlob(b.getLogo());
		ps.setBlob(7, isLogo);
		
		InputStream isScan = bufferedImageToBlob(b.getScan());
		ps.setBlob(8, isScan);
		
		ps.setBoolean(9, b.isPagata());
		
		int res = ps.executeUpdate();
			System.out.println(res);
			return true;
		
	}
}
