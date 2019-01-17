package com.spring.mvc;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class Student {
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String country;
	private String[] favGames;

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

	public String[] getFavGames() {
		return favGames;
	}

	public void setFavGames(String[] favGames) {
		this.favGames = favGames;
	}

}
