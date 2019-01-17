package com.airlinereservationsystem.modelview;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class FlightSearch {

	@NotNull
	@NotBlank
	private String source;
	
	@NotNull
	@NotBlank
	private String destination;
	
	@NotNull
	private Date date;

	public FlightSearch() {
	}

	public FlightSearch(@NotNull @NotBlank String source, @NotNull @NotBlank String destination, @NotNull Date date) {
		this.source = source;
		this.destination = destination;
		this.date = date;
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "FlightSearch [source=" + source + ", destination=" + destination + ", date=" + date + "]";
	}
	
	
}
