package ca.com.crud.main;

import ca.com.crud.dao.ContactDao;
import ca.com.crud.model.ContactUs;

public class ContactTest {
	public static void main(String[] args) {
		ContactDao contactDao = new ContactDao();

//============================== Method save ======================================
		
//		ContactUs contact = new ContactUs();
//		contact.setEmail("GostBusters@gmail.com");
//		contact.setPhone("No Phone");
//		contact.setNewMessage("This is a teste contact message");
//		contactDao.save(contact); // Method called from "ContacDao.java"

		// =================  UPDATE CONTACTS  ================================
//		ContactUs contact1 = new ContactUs();
//		contact1.setContactID(4);
//		contact1.setEmail("thenewguy@gmail.com");
//		contact1.setPhone("No Cell");
//		contact1.setNewMessage("Email updading");
//		contactDao.update(contact1); // Called from "ContacDao.java"

// =============================== Method remove ================================================

//		contactDao.removeById(1);
		
// ============================= Method get contact list ==========================================

//		for (ContactUs c : contactDao.getContactUs()) {
//			System.out.println("Email: " + c.getEmail() + "\nPhone: " + c.getPhone() + "\nNew Message: " + c.getNewMessage() + "\n");
//		}
	}

}
