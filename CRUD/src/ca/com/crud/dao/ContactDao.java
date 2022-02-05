package ca.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ca.com.crud.factory.ConnectionFactory;
import ca.com.crud.model.ContactUs;

public class ContactDao {
// Create CRUD methods
	// Method save
	public void save(ContactUs contact) {
		// code to "query" here
		String sql = "INSERT INTO ContactUs (Email, Phone, NewMessage )" + "VALUES(?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Code to add data to DB
			conn = ConnectionFactory.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contact.getEmail());
			
			pstm.setString(2, contact.getPhone());
			
			pstm.setString(3, contact.getNewMessage());
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.cancel();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Method remove
	public List<ContactUs> getContactUs() {
		String sql = "SELECT * FROM ContactUs";
		
		List<ContactUs> contacts =  new ArrayList<ContactUs>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				ContactUs contact = new ContactUs();
				
				contact.setContactID(rset.getInt("ContactID"));
				contact.setEmail(rset.getString("Email"));
				contact.setPhone(rset.getString("Phone"));
				contact.setNewMessage(rset.getString("NewMessage"));
				contacts.add(contact);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rset != null) {
					rset.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return contacts;
	}
	// Method remove
	public void removeById(int ContactID) {
		// code to "query" here
		String sql = "DELETE FROM ContactUs WHERE ContactID = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, ContactID);
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Method remove
	public void update(ContactUs contact) {
		String sql = "UPDATE ContactUs SET Email = ?, Phone = ?, NewMessage = ?, WHERE ContactID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, contact.getEmail());
			pstm.setString(2, contact.getPhone());
			pstm.setString(3, contact.getNewMessage());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}