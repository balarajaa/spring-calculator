package com.learning.sc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AgeValidator implements ConstraintValidator<Age, Integer> {
	
	private int lower;
	private int upper;

	@Override
	public void initialize(Age age) {
		// I can write the post construct work here
		this.lower = age.lower();
		this.upper = age.upper();
	
	}
	@Override
	public boolean isValid(Integer age, ConstraintValidatorContext context) {
		
		if(age==null)
			return false;
		
		if(age<lower || age>upper) {
			return false;
		}

		return true;
	}

}
