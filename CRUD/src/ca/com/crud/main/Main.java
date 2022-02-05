package ca.com.crud.main;

import ca.com.crud.dao.ContactDao;
import ca.com.crud.model.ContactUs;

public class Main {
	public static void main(String[] args) {
		ContactDao contactDao = new ContactDao();

//		ContactUs contact = new ContactUs();
//		contact.setEmail("JimGordan@gmail.com");
//		contact.setPhone("11 99879-7876");
//		contact.setNewMassage("This is my first contact");
//
//		contactDao.save(contact); // Method called from "ContacDao.java"
//
		// =================  UPDATE CONTACTS  ================================
		ContactUs contact1 = new ContactUs();
		contact1.setContactID(12);
		contact1.setEmail("AthenaNatalie@gmail.com");
		contact1.setPhone("No Cell");
		contact1.setNewMessage("Email correction");
		contactDao.update(contact1); // Called from "ContacDao.java"

//		contactDao.removeById(1);
//		 
//		for (ContactUs c : contactDao.getContactUs()) {
//			System.out.println("Email: " + c.getEmail());
//		}
	}

}
