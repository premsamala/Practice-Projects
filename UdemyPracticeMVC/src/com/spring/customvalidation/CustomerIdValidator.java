package com.spring.customvalidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CustomerIdValidator implements ConstraintValidator<CustomerId, String> {

	private String input;

	@Override
	public void initialize(CustomerId constraintAnnotation) {
		input = constraintAnnotation.value();
	}

	@Override
	public boolean isValid(String theCode, ConstraintValidatorContext constraintValidatorContext) {
		boolean result;
		System.out.println(theCode + "     " + constraintValidatorContext);
		if (theCode != null) {
			result = input.startsWith("700");
		} else {
			result = true;
		}

		return result;
	}

}
