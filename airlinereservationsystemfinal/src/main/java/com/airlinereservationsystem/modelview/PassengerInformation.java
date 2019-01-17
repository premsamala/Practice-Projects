package com.airlinereservationsystem.modelview;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

@Component
public class PassengerInformation {

	@NotNull
	@NotBlank
	private String name;
	
	@NotNull
	@Min(value=1)
	private Integer age;
	
	@NotNull
	@NotBlank
	private String gender;

	public PassengerInformation() {
	}

	public PassengerInformation(@NotNull @NotBlank String name, @NotNull @Min(1) Integer age,
			@NotNull @NotBlank String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PassengerInformation [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
