package com.spring.mvc;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;
import org.springframework.stereotype.Component;

@Component
// @Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Address {

	@NotNull
	@Size(min = 1, message = "Required")
	private String streetAddress;

	@NotNull
	@Size(min = 1, message = "Required")
	private String city;

	@NotNull
	@Size(min = 1, message = "Required")
	private String state;

	@NotNull
	@Pattern(regexp = "\\d{5}", message = "Please enter valid zipcode")
	private String zipCode;

	@NotNull
	@Range(min = 10, max = 100, message = "Please enter age between 1 to 100")
	private Integer age;

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Address [addressType=" + ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state
				+ ", zipCode=" + zipCode + "]";
	}

}
