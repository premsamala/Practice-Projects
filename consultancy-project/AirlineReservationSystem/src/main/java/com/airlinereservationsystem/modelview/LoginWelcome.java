package com.airlinereservationsystem.modelview;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class LoginWelcome {

	@NotNull
	@NotBlank
	private String username;
	
	@NotNull
	@NotBlank
	private String password;

	public LoginWelcome() {
	}

	public LoginWelcome(@NotNull @NotBlank String username, @NotNull @NotBlank String password) {
		this.username = username;
		this.password = password;
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
	
	
}
