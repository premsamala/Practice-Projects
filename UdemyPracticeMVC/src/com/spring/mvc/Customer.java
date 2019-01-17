package com.spring.mvc;

import java.util.Arrays;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.customvalidation.CustomerId;

@Component
// @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Customer {
	@NotNull
	@Size(min = 1, message = "Required")
	private String firstName;

	@NotNull
	@Size(min = 1, message = "Required")
	private String lastName;

	@NotNull
	private String country;

	@NotNull
	private String gender;

	private String[] favGames;

	@NotNull
	@CustomerId
	private String customerId;

	@Valid
	@NotNull
	private Address address;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Address getAddress() {
		return address;
	}

	@Autowired(required = true)
	public void setAddress(Address address) {
		this.address = address;
	}

	public String[] getFavGames() {
		return favGames;
	}

	public void setFavGames(String[] favGames) {
		this.favGames = favGames;

	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", country=" + country + ", gender="
				+ gender + ", favGames=" + Arrays.toString(favGames) + ", customerId=" + customerId + ", address="
				+ address + "]";
	}

}
