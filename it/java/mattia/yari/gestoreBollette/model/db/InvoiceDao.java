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
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;
import it.java.mattia.yari.gestoreBollette.model.beans.Invoice;



/**
 * @author yari
 *
 */
public class InvoiceDao implements Dao {

	@Override
	/* return all from table Invoice */
	public  List<Invoice> getAll() {
		List<Invoice>result = new ArrayList<Invoice>(); 
		DbConnection db = DbConnection.getInstance();
		String sql = "SELECT * FROM invoice";
		try {
				PreparedStatement ps = db.getConn().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Invoice invoice = filterInvoiceOutput(rs);
					result.add(invoice);
					
				db.getConn().close();
				return result;
				
			}
		} catch (SQLException e) {
			e.getMessage();
			
		}
		return null;
	  }

	@Override
	/*return one invoice correspond to invoice ID & supplierName */
	public Invoice get(String invoiceID, String supplierName) {
		Invoice invoice = new Invoice();
		DbConnection db = DbConnection.getInstance();
		String sql = "SELECT * FROM invoice WHERE invoiceID = ? AND supplierName = ?";
		try {
			PreparedStatement ps = db.getConn().prepareStatement(sql);
			ps.setString(1, invoiceID);
			ps.setString(2, supplierName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Invoice i = filterInvoiceOutput(rs);
				invoice = i;
			}
			db.getConn().close();
			return invoice;
			
		} catch (SQLException e) {
			e.getMessage();
			
		}
		return null;
	}

	@Override
	/* insert a new invoice into DB */
	public boolean add(Invoice i) {
		DbConnection db = DbConnection.getInstance();
		String sql = "INSERT INTO invoice (invoiceID, supplierName, clientID, amount, release, dueDate, scan, paid) VALUES (?,?,?,?,?,?,?,?)";
		try {
			
			PreparedStatement ps = db.getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setString(1, i.getInvoiceID());
			ps.setString(2, i.getSupplierName());
			ps.setString(3, i.getClientID());
			ps.setFloat(4, i.getAmount());
			ps.setDate(5, Date.valueOf(i.getRelease()));
			ps.setDate(6, Date.valueOf(i.getDueDate()));
			ps.setBlob(7, bufferedImageToBlob(i.getScan()));
			ps.setBoolean(8, i.isPaid());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int key = rs.getInt(1);
				System.out.println("Add successful with return code : "+ key);
				return true;
			
		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}

	

	@Override
	/*Update an invoice*/
	public  boolean update(Invoice i) {
		DbConnection db = DbConnection.getInstance();
		String sql = "UPDATE invoice SET invoiceID = ?, supplierName = ?, clientID = ?, amount = ?, release = ?, dueDate = ?, scan = ?, paid = ?"
					+"WHERE ID = ?";
			try {
	
				PreparedStatement ps = db.getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setString(1, i.getInvoiceID());
				ps.setString(2, i.getSupplierName());
				ps.setString(3, i.getClientID());
				ps.setFloat(4, i.getAmount());
				ps.setDate(5, Date.valueOf(i.getRelease()));
				ps.setDate(6, Date.valueOf(i.getDueDate()));
				ps.setBlob(7, bufferedImageToBlob(i.getScan()));
				ps.setBoolean(8, i.isPaid());
				ps.setInt(9, i.getID());
				ps.executeUpdate();
				ResultSet rs = ps.getGeneratedKeys();
				int key = rs.getInt(1);
				System.out.println("Update successful with return code : "+ key);
				return true;
	
			} catch (SQLException e) {
				e.getMessage();
				return false;
			}
	}

	
	@Override
	/*  Delete an invoice by ID  */
	public boolean delete(Invoice i) {
		DbConnection db = DbConnection.getInstance();
		String sql = "DELETE FROM invoice WHERE ID = ?";
		try {
			
			PreparedStatement ps = db.getConn().prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			ps.setInt(1, i.getID());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			int key = rs.getInt(1);
			System.out.println("Delete successful with return code : "+ key);
			return true;

		} catch (SQLException e) {
			e.getMessage();
			return false;
		}
	}

	/*  Service Methods for Image <-> Blob conversion  */
	private static BufferedImage blobToBufferedImage(Blob blob) {
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
	
	/* Filter input data from DB for Invoice Table  */
	private static Invoice filterInvoiceOutput(ResultSet rs) {
		
		Invoice invoice = new Invoice();
		
			try {
				invoice.setID(rs.getInt(1));
				
			  if((rs.getString(2) != null) && (rs.getString(3) != null)) {
				  invoice.setInvoiceID(rs.getString(2));
				  invoice.setSupplierName(rs.getString(3));
				  }
			  }catch(NullPointerException e) {
				  e.getMessage();
			  }catch(SQLException e) {
				  e.getMessage();
			  }
			
			try {
				  if(rs.getString(4) != null) {
					  invoice.setClientID(rs.getString(4));
					  }
				  }catch(SQLException e) {
					  e.getMessage();
				  }
			
			try {
				  invoice.setAmount(rs.getFloat(5));
			}catch(SQLException e) {
				  e.getMessage();
			  }
			
			try {
				 LocalDate release;
				 Date sqlRelease = rs.getDate(6);
				 if(sqlRelease != null) {
					 release = sqlRelease.toLocalDate();
					invoice.setRelease(release);
				 }
				  
			}catch(SQLException e) {
				  e.getMessage();
			  }
			  
			try {
				 LocalDate dueDate;
				 Date sqlDueDate = rs.getDate(7);
				 if(sqlDueDate != null) {
					dueDate = sqlDueDate.toLocalDate();
					invoice.setDueDate(dueDate);
				 }
				  
			}catch(SQLException e) {
				  e.getMessage();
			  }
			
			try {
				Blob sqlScan = rs.getBlob(8);
				if(sqlScan != null) {
				BufferedImage scan = blobToBufferedImage(sqlScan);
				invoice.setScan(scan);
				}
			} catch (SQLException e) {
				e.getMessage();
			} 
			
			try {
				boolean paid = rs.getBoolean(9);
				invoice.setPaid(paid);
				
			} catch (SQLException e) {
				e.getMessage();
			}
			
		return invoice;
		
	}
	
}
