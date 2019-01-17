package com.airlinereservationsystem.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.airlinereservationsystem.model.UserDetails;

public interface UserDetailsRepository extends CrudRepository<UserDetails, String> {

	public Optional<UserDetails> findByUsernameAndPassword(String username, String password);
}
