package com.airlinereservationsystem.modelview;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class PaymentDetails {

	@NotNull
	@NotBlank
	private String cardNumber;
	
	@NotNull
	@NotBlank
	private String cardholderName;
	
	@NotNull
	private Integer cvv;
	
	@NotNull
	private Integer apin;
	
	@NotNull
	private Integer expiryMonth;
	
	@NotNull
	private Integer expiryYear;

	public PaymentDetails() {
		super();
	}

	public PaymentDetails(@NotNull @NotBlank String cardNumber, @NotNull @NotBlank String cardholderName,
			@NotNull Integer cvv, @NotNull Integer apin, @NotNull Integer expiryMonth, @NotNull Integer expiryYear) {
		super();
		this.cardNumber = cardNumber;
		this.cardholderName = cardholderName;
		this.cvv = cvv;
		this.apin = apin;
		this.expiryMonth = expiryMonth;
		this.expiryYear = expiryYear;
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

	@Override
	public String toString() {
		return "PaymentDetails [cardNumber=" + cardNumber + ", cardholderName=" + cardholderName + ", cvv=" + cvv
				+ ", apin=" + apin + ", expiryMonth=" + expiryMonth + ", expiryYear=" + expiryYear + "]";
	}
	
	
	
}
