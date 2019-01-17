package com.airlinereservationsystem.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.airlinereservationsystem.model.FlightDetails;

public interface FlightDetailsRepository extends CrudRepository<FlightDetails, String> {

	public Optional<List<FlightDetails>> findBySourceAndDestination(String source, String destination);
}
