package com.airlinereservationsystem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

@Entity
@Table(name="user_details_table")
public class UserDetails {

	@Id
	@Column(name="Username")
	private String username;
	
	@Column(name="Password")
	private String password;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="City")
	private String city;
	
	@Column(name="Email")
	private String email;
	
	@Column(name="Phone")
	private String phone;

	public UserDetails() {
	}

	public UserDetails(@NotEmpty String username, @NotEmpty String password, @NotEmpty String name,
			@NotEmpty String city, @NotEmpty String email, @NotEmpty String phone) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.city = city;
		this.email = email;
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Users_Details_Table [username=" + username + ", password=" + password + ", name=" + name + ", city="
				+ city + ", email=" + email + ", phone=" + phone + "]";
	}
	
	
	
	
}
