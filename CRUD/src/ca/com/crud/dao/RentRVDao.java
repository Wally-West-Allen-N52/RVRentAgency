package ca.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ca.com.crud.factory.ConnectionFactory;
import ca.com.crud.model.RentRV;

public class RentRVDao {
// Create CRUD methods 
	//============================== Method save ======================================
	public static void save(RentRV rentRV) {
		// code to "query" here
		String sql = "INSERT INTO RentRV (FindRV, Price )" + "VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Code to add data to DB
			conn = ConnectionFactory.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, rentRV.getFindRV());
			pstm.setFloat(2, rentRV.getPrice());
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

	// ============================= Method get contact list ==========================================
	public List<RentRV> getContactUs() {
		String sql = "SELECT * FROM RentRV";
		
		List<RentRV> rents =  new ArrayList<RentRV>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				RentRV rent = new RentRV();
		
				rent.setRentRVID(rset.getInt("RentRVID"));
				rent.setFindRV(rset.getString("FindRV"));
				rent.setPrice(rset.getFloat("Price"));
				rents.add(rent);
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
		return rents;
	}
	// =============================== Method remove ================================================
	public void removeById(int RentRVID) {
		// code to "query" here
		String sql = "DELETE FROM RentRV WHERE RentRVID = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, RentRVID);
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

	// ========================== Method update =============================================
	public static void update(RentRV rentRV) {
		String sql = "UPDATE RentRV SET FindRV = ?, Price = ? WHERE RentRVID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, rentRV.getFindRV());
			pstm.setFloat(2, rentRV.getPrice());
			pstm.setInt(3, rentRV.getRentRVID());
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