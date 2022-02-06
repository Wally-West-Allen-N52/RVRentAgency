package ca.com.crud.model;

public class RentRV {
	private int RentRVID;
	private String FindRV;
	private float Price;

	public int getRentRVID() {
		return RentRVID;
	}

	public void setRentRVID(int rentRVID) {
		RentRVID = rentRVID;
	}

	public String getFindRV() {
		return FindRV;
	}

	public void setFindRV(String findRV) {
		FindRV = findRV;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}
}
