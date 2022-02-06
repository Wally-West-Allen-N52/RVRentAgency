package ca.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ca.com.crud.factory.ConnectionFactory;
import ca.com.crud.model.BuyRV;

public class BuyRVDao {
// Create CRUD methods
	//============================== Method save ======================================
	public static void save(BuyRV buytRV) {
		// code to "query" here
		String sql = "INSERT INTO BuyRV (FindRV, Price )" + "VALUES(?, ?)";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Code to add data to DB
			conn = ConnectionFactory.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, buytRV.getFindRV());
			pstm.setFloat(2, buytRV.getPrice());
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
	public List<BuyRV> getgetBuytRV() {
		String sql = "SELECT * FROM BuytRV";
		
		List<BuyRV> buys =  new ArrayList<BuyRV>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				BuyRV buy = new BuyRV();
		
				buy.setBuyRVID(rset.getInt("BuyRVID"));
				buy.setFindRV(rset.getString("FindRV"));
				buy.setPrice(rset.getFloat("Price"));
				buys.add(buy);
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
		return buys;
	}
	// =============================== Method remove ================================================
	public void removeById(int BuyRVID) {
		// code to "query" here
		String sql = "DELETE FROM BuyRV WHERE BuyRVID = ?";
		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, BuyRVID);
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
	public static void update(BuyRV buyRV) {
		String sql = "UPDATE BuyRV SET FindRV = ?, Price = ? WHERE BuyRVID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, buyRV.getFindRV());
			pstm.setFloat(2, buyRV.getPrice());
			pstm.setInt(3, buyRV.getBuyRVID());
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