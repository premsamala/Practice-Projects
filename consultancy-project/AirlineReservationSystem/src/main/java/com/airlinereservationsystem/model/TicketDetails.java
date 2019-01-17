package com.airlinereservationsystem.model;

import java.util.List;
import java.sql.Date;
import java.sql.Time;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Entity
@Table(name="ticket_details_table")
public class TicketDetails {

	@Id
	@Column(name="PNR")
	private String pnr;
	
	@Column(name="Booking_date")
	private Date bookingDate;
	
	@Column(name="Departure_date")
	private Date departureDate;
	
	@Column(name="Departure_time")
	private Time departureTime;
	
	@Column(name="Total_fare")
	private Double totalFare;
	
	@OneToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="Flight_id")
	private FlightDetails flightDetails;
	
	@ManyToOne(fetch=FetchType.LAZY, cascade= {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name="Username")
	private UserDetails userDetails;

	public TicketDetails() {
	}

	public TicketDetails(String pnr, Date bookingDate, Date departureDate, Time departureTime, Double totalFare,
			FlightDetails flightDetails, UserDetails userDetails) {
		this.pnr = pnr;
		this.bookingDate = bookingDate;
		this.departureDate = departureDate;
		this.departureTime = departureTime;
		this.totalFare = totalFare;
		this.flightDetails = flightDetails;
		this.userDetails = userDetails;
	}

	public String getPnr() {
		return pnr;
	}

	public void setPnr(String pnr) {
		this.pnr = pnr;
	}

	public Date getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(Date bookingDate) {
		this.bookingDate = bookingDate;
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

	public Double getTotalFare() {
		return totalFare;
	}

	public void setTotalFare(Double totalFare) {
		this.totalFare = totalFare;
	}

	public FlightDetails getFlightDetails() {
		return flightDetails;
	}

	public void setFlightDetails(FlightDetails flightDetails) {
		this.flightDetails = flightDetails;
	}

	public UserDetails getUserDetails() {
		return userDetails;
	}
	
	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	@Override
	public String toString() {
		return "TicketDetails [pnr=" + pnr + ", bookingDate=" + bookingDate + ", departureDate=" + departureDate
				+ ", departureTime=" + departureTime + ", totalFare=" + totalFare + ", flightDetails=" + flightDetails
				+ ", userDetails=" + userDetails + "]";
	}

}
