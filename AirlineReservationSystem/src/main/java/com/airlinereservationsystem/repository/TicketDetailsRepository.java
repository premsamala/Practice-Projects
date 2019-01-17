package com.airlinereservationsystem.repository;

import org.springframework.data.repository.CrudRepository;

import com.airlinereservationsystem.model.TicketDetails;

public interface TicketDetailsRepository extends CrudRepository<TicketDetails, String> {

}
