package com.airlinereservationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flight_details_table")
public class FlightDetails {

	@Id
	@Column(name="Flightid")
	private String flightId;
	
	@Column(name="Source")
	private String source;
	
	@Column(name="Destination")
	private String destination;
	
	@Column(name="Fare")
	private Double fare;

	public FlightDetails() {
	}

	public FlightDetails(String flightId, String source, String destination, Double fare) {
		this.flightId = flightId;
		this.source = source;
		this.destination = destination;
		this.fare = fare;
	}

	public String getFlightId() {
		return flightId;
	}

	public void setFlightId(String flightId) {
		this.flightId = flightId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Double getFare() {
		return fare;
	}

	public void setFare(Double fare) {
		this.fare = fare;
	}

	@Override
	public String toString() {
		return "Flight_Details [flightId=" + flightId + ", source=" + source + ", destination=" + destination
				+ ", fare=" + fare + "]";
	}
	
	
}
