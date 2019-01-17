package com.airlinereservationsystem.modelview;



import org.springframework.stereotype.Component;

@Component
public class FlightSelectionDetails {

	private String flightId;
	
	

	public FlightSelectionDetails() {
	}

	public FlightSelectionDetails(String flightId) {
		this.flightId = flightId;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}


	@Override
	public String toString() {
		return "FlightSelectionDetails [flightId=" + flightId;
	}
	
	
}
