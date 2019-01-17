package com.airlinereservationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="creditcard_details_table")
public class CreditcardDetails {

	@Id
	@Column(name="Card_number")
	private String cardNumber;
	
	@Column(name="Card_holder_name")
	private String cardholderName;
	
	@Column(name="Cvv")
	private Integer cvv;
	
	@Column(name="APIN")
	private Integer apin;
	
	@Column(name="Expiry_month")
	private Integer expiryMonth;
	
	@Column(name="Expiry_year")
	private Integer expiryYear;
	
	@Column(name="Total_bill")
	private Double totalBill;

	public CreditcardDetails() {
	}

	public CreditcardDetails(String cardNumber, String cardholderName, Integer cvv, Integer apin, Integer expiryMonth,
			Integer expiryYear, Double totalBill) {
		this.cardNumber = cardNumber;
		this.cardholderName = cardholderName;
		this.cvv = cvv;
		this.apin = apin;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
		this.totalBill = totalBill;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardholderName() {
		return cardholderName;
	}

	public void setCardholderName(String cardholderName) {
		this.cardholderName = cardholderName;
	}

	public Integer getCvv() {
		return cvv;
	}

	public void setCvv(Integer cvv) {
		this.cvv = cvv;
	}

	public Integer getApin() {
		return apin;
	}

	public void setApin(Integer apin) {
		this.apin = apin;
	}

	public Integer getExpiryMonth() {
		return expiryMonth;
	}

	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}

	public Integer getExpiryYear() {
		return expiryYear;
	}

	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}

	public Double getTotalBill() {
		return totalBill;
	}

	public void setTotalBill(Double totalBill) {
		this.totalBill = totalBill;
	}

	@Override
	public String toString() {
		return "CreditcardDetails [cardNumber=" + cardNumber + ", cardholderName=" + cardholderName + ", cvv=" + cvv
				+ ", apin=" + apin + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + ", totalBill="
				+ totalBill + "]";
	}
	
	
}
