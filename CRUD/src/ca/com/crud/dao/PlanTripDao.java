package ca.com.crud.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ca.com.crud.factory.ConnectionFactory;
import ca.com.crud.model.BuyRV;
import ca.com.crud.model.ContactUs;
import ca.com.crud.model.PlanTrip;
import ca.com.crud.model.RentRV;

public class PlanTripDao {
// Create CRUD methods 
	//============================== Method save ======================================
	public void save(PlanTrip planTrip) {
		// code to "query" here
		String sql = "INSERT INTO PlanTrip (Beginning_from, Arriving_at, fk_BuyRVID, fk_RentRVID, fk_ContactID )" + "VALUES(?, ?, ?, ?, ?)"; // Auto increment ID

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			// Code to add data to DB
			conn = ConnectionFactory.createConnectionSQLServer();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, planTrip.getBeginning_from());			
			pstm.setString(2, planTrip.getArriving_at());
			pstm.setInt(3, planTrip.getBuyRVID());
			pstm.setInt(4, planTrip.getRentRVID());
			pstm.setInt(5, planTrip.getContactID());
			
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
	public static List<PlanTrip> getPlanTrip() {
		String sql = "SELECT "
				+ "P.Plan_tripID, P.Beginning_from, P.Arriving_at,\r\n"
				+ "c.ContactID, c.Email as Email, c.Phone as Phone, c.NewMessage as NewMessage,\r\n"
				+ "b.BuyRVID, b.FindRV as FindRV, b.Price as Proce,\r\n"
				+ "r.RentRVID, r.FindRV as Findrv, r.Price from PlanTrip as P\r\n"
				+ "inner join ContactUs as c on P.fk_ContactID = c.ContactID\r\n"
				+ "inner join BuyRV as b on P.fk_BuyRVID = b.BuyRVID\r\n"
				+ "inner join RentRV as r on P.fk_RentRVID = r.RentRVID";
		 
		List<PlanTrip> planTrips =  new ArrayList<PlanTrip>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				PlanTrip planTrip = new PlanTrip();
				ContactUs contact = new ContactUs();
				BuyRV buyRV = new BuyRV();
				RentRV rentRV = new RentRV();
				
// ============================ Table Plan a Trip ================================================				
				planTrip.setContactID(rset.getInt("ContactID"));
				planTrip.setBeginning_from(rset.getString("Beginning_from"));
				planTrip.setArriving_at(rset.getString("Arriving_at"));
				
// ============================ Table Contact Us ================================================		
				contact.setContactID(rset.getInt("ContactID"));
				contact.setEmail(rset.getString("Email"));
				contact.setPhone(rset.getString("Phone"));
				contact.setNewMessage(rset.getString("NewMessage"));
		
				planTrip.setContactUs(contact);
				
// ============================ Table Buy RV ================================================				
				buyRV.setBuyRVID(rset.getInt("BuyRVID"));
				buyRV.setFindRV(rset.getString("FindRV"));
				buyRV.setPrice(rset.getFloat("Price"));
				
				planTrip.setBuyRV(buyRV);
				
// ============================ Table Rent RV ================================================
				
				rentRV.setRentRVID(rset.getInt("RentRVID"));
				rentRV.setFindRV(rset.getString("FindRV"));
				rentRV.setPrice(rset.getFloat("Price"));
				
				planTrip.setRentRV(rentRV);
				
// ============================ To add ================================================

				planTrips.add(planTrip);
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
		return planTrips;
	}
	// =============================== Method remove ================================================
	public void removeById(int ContactID) {
		// code to "query" here
		String sql = "DELETE FROM PlanTrip WHERE Plan_tripID = ?";
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

	// ========================== Method update =============================================
	public void update(PlanTrip planTrip) {
		String sql = "UPDATE PlanTrip SET Beginning_from = ?, Arriving_at = ?, fk_BuyRVID = ? fk_RentRVID = ? fk_ContactID = ? WHERE Plan_tripID = ?";

		Connection conn = null;
		PreparedStatement pstm = null;

		try {
			conn = ConnectionFactory.createConnectionSQLServer();
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, planTrip.getBeginning_from());
			pstm.setString(2, planTrip.getArriving_at());
			pstm.setInt(3, planTrip.getBuyRVID());
			pstm.setInt(4, planTrip.getRentRVID());
			pstm.setInt(5, planTrip.getContactID());
			pstm.setInt(6, planTrip.getPlan_tripID());
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