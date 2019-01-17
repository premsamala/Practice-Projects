package com.airlinereservationsystem.modelview;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class PassengerInformationList {

	@NotNull
	@Valid
	private List<PassengerInformation> passengerInformationList;

	public PassengerInformationList() {
		super();
	}

	public PassengerInformationList(@NotNull @Valid List<PassengerInformation> passengerInformationList) {
		super();
		this.passengerInformationList = passengerInformationList;
	}

	public List<PassengerInformation> getPassengerInformationList() {
		return passengerInformationList;
	}

	public void setPassengerInformationList(List<PassengerInformation> passengerInformationList) {
		this.passengerInformationList = passengerInformationList;
	}

	
	
	
}
