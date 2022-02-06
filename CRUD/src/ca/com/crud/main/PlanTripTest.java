package ca.com.crud.main;

import ca.com.crud.dao.PlanTripDao;
import ca.com.crud.model.PlanTrip;

public class PlanTripTest {

	public static void main(String[] args) {
		PlanTripDao planTripDao = new PlanTripDao();

// ================== Save =================================== 		
//		PlanTrip planTrip = new PlanTrip();
//		planTrip.setBeginning_from("Saskatchewan - CA");
//		planTrip.setArriving_at("São Paulo - BR");
//		planTrip.setBuyRVID(1);
//		planTrip.setRentRVID(1);
//		planTrip.setContactID(2);
//
//		planTripDao.save(planTrip);
// =================== ===================================

// =================== ===================================

// =================== Delete ===================================
//		planTripDao.removeById(17);
		
// =================== To update a contact ===================================
//		PlanTrip planTrip = new PlanTrip();
//		planTrip.setContactID(1);
//		planTrip.setBeginning_from("Nunavut - CA");
//		planTrip.setArriving_at("Utah - USA");
//		planTrip.setBuyRVID(1);
//		planTrip.setRentRVID(1);
//		planTrip.setContactID(2);
//		
//		planTripDao.update(planTrip); // Called from "PlanTripcDao.java"

// =================== Get List ===================================
		for (PlanTrip p : PlanTripDao.getPlanTrip()) {
			System.out.println("\nBeginning from: " + p.getBeginning_from()
			+ "Arriving At: "  + p.getArriving_at()
			+ "Contact Us from a E-mail: " + p.getContactUs().getEmail()
			+ "Phone: " + p.getContactUs().getPhone()
			+ "Send a Message: " + p.getContactUs().getNewMessage()
			+ "Find One RV:" + p.getRentRV().getFindRV()
			+ "See Price $: " + p.getBuyRV().getFindRV());
		}
	}

}
