package ca.com.crud.model;

public class PlanTrip {
	
	private int Plan_tripID;
	private String Beginning_from;
	private String Arriving_at;
	
	private int BuyRVID;
	private BuyRV buyRV;
	private int RentRVID;
	private RentRV rentRV;
	private int ContactID;
	private ContactUs contactUs;
	
	public int getPlan_tripID() {
		return Plan_tripID;
	}
	public void setPlan_tripID(int plan_tripID) {
		Plan_tripID = plan_tripID;
	}
	public String getBeginning_from() {
		return Beginning_from;
	}
	public void setBeginning_from(String beginning_from) {
		Beginning_from = beginning_from;
	}
	public String getArriving_at() {
		return Arriving_at;
	}
	public void setArriving_at(String arriving_at) {
		Arriving_at = arriving_at;
	}
	public int getBuyRVID() {
		return BuyRVID;
	}
	public void setBuyRVID(int buyRVID) {
		BuyRVID = buyRVID;
	}
	public BuyRV getBuyRV() {
		return buyRV;
	}
	public void setBuyRV(BuyRV buyRV) {
		this.buyRV = buyRV;
	}
	public int getRentRVID() {
		return RentRVID;
	}
	public void setRentRVID(int rentRVID) {
		RentRVID = rentRVID;
	}
	public RentRV getRentRV() {
		return rentRV;
	}
	public void setRentRV(RentRV rentRV) {
		this.rentRV = rentRV;
	}
	public int getContactID() {
		return ContactID;
	}
	public void setContactID(int contactID) {
		ContactID = contactID;
	}
	public ContactUs getContactUs() {
		return contactUs;
	}
	public void setContactUs(ContactUs contactUs) {
		this.contactUs = contactUs;
	}
}
