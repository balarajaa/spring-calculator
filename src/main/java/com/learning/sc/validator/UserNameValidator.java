package com.learning.sc.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.learning.sc.api.UserRegistrationDTO;

public class UserNameValidator implements Validator {

	// check if UserNameValidator supports a given object
	@Override
	public boolean supports(Class<?> clazz) {
		return UserRegistrationDTO.class.equals(clazz);
	}

	// write the custom validator logic
	@Override
	public void validate(Object target, Errors errors) {
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName", "userName.empty", "User Name can't be empty");
		
		String userName = ((UserRegistrationDTO)target).getUserName();
		if (!userName.contains("_")) {
			errors.rejectValue("userName", "userName.invalidString", "userName must contains '_'");
		}
	
	}

}
