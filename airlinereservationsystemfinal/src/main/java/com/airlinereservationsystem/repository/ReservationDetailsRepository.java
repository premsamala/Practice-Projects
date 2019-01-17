package com.airlinereservationsystem.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.airlinereservationsystem.model.FlightDetails;
import com.airlinereservationsystem.model.ReservationDetails;

public interface ReservationDetailsRepository extends CrudRepository<ReservationDetails, Integer> {

	public Optional<List<ReservationDetails>> findByFlightDetailsIn(List<FlightDetails> flightDetails);
	
	public Optional<List<ReservationDetails>> findByDepartureDateAndSourceAndDestination(Date date, String source, String destination);
	
	public Optional<ReservationDetails> findByFlightDetails(FlightDetails flightDetails);
}
