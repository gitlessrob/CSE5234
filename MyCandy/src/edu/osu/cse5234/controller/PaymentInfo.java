package edu.osu.cse5234.controller;

public class PaymentInfo {
	
	private String ccNum;
	private String expiryDate;
	private String cvvCode;
	private String cardHolderName;
	
	public String getCcNum() {
		return ccNum;
	}
	public void setCcNum(String ccNum) {
		this.ccNum = ccNum;
	}
	
	public String getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	
	public String getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(String cvvCode) {
		this.cvvCode = cvvCode;
	}
	
	public String getCardHolderName() {
		return cardHolderName;
	}
	public void setCardHolderName(String cardHolderName) {
		this.cardHolderName = cardHolderName;
	}
	
}
