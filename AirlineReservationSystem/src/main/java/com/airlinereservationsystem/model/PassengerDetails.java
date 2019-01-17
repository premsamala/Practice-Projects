package com.airlinereservationsystem.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="passenger_details_table")
public class PassengerDetails {

	@Id
	@Column(name="Passenger_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer passengerId;
	
	@Column(name="Passenger_name")
	private String passengerName;
	
	@Column(name="Passenger_age")
	private Integer passengerAge;
	
	@Column(name="Passenger_gender")
	private String passengerGender;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="PNR")
	private TicketDetails ticketDetails;

	public PassengerDetails() {
	}

	public PassengerDetails(Integer passengerId, String passengerName, Integer passengerAge, String passengerGender,
			TicketDetails ticketDetails) {
		this.passengerId = passengerId;
		this.passengerName = passengerName;
		this.passengerAge = passengerAge;
		this.passengerGender = passengerGender;
		this.ticketDetails = ticketDetails;
	}

	public Integer getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(Integer passengerId) {
		this.passengerId = passengerId;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public Integer getPassengerAge() {
		return passengerAge;
	}

	public void setPassengerAge(Integer passengerAge) {
		this.passengerAge = passengerAge;
	}

	public String getPassengerGender() {
		return passengerGender;
	}

	public void setPassengerGender(String passengerGender) {
		this.passengerGender = passengerGender;
	}

	public TicketDetails getTicketDetails() {
		return ticketDetails;
	}

	public void setTicketDetails(TicketDetails ticketDetails) {
		this.ticketDetails = ticketDetails;
	}

	@Override
	public String toString() {
		return "PassengerDetails [passengerId=" + passengerId + ", passengerName=" + passengerName + ", passengerAge="
				+ passengerAge + ", passengerGender=" + passengerGender + ", ticketDetails=" + ticketDetails + "]";
	}
	
	
}
