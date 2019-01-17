package com.airlinereservationsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.airlinereservationsystem.model.PassengerDetails;

public interface PassengerDetailsRepository extends CrudRepository<PassengerDetails, Integer> {

}
