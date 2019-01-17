package com.airlinereservationsystem.model;

import java.sql.Date;
import java.sql.Time;

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
@Table(name="reservation_details_table")
public class ReservationDetails {
	
	@Id
	@Column(name="Id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="Departure_date")
	private Date departureDate;
	
	@Column(name="Departure_time")
	private Time departureTime;
	
	@Column(name="Source")
	private String source;
	
	@Column(name="Destination")
	private String destination;
	
	@Column(name="Available_seats")
	private Integer availableSeats;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="Flight_id")
	private FlightDetails flightDetails;

	public ReservationDetails() {
	}


	public ReservationDetails(Integer id, Date departureDate, Time departureTime, String source, String destination,
			Integer availableSeats, FlightDetails flightDetails) {
		this.id = id;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.source = source;
		this.destination = destination;
		this.availableSeats = availableSeats;
		this.flightDetails = flightDetails;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}

	public Time getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(Time departureTime) {
		this.departureTime = departureTime;
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

	

	public Integer getAvailableSeats() {
		return availableSeats;
	}


	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}


	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	@Override
	public String toString() {
		return "ReservationDetails [id=" + id + ", departureDate=" + departureDate + ", departureTime=" + departureTime
				+ ", source=" + source + ", destination=" + destination + ", availableSeats=" + availableSeats + ", flightDetails="
				+ flightDetails + "]";
	}
	
	

}
