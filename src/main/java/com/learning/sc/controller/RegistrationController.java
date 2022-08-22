package com.learning.sc.controller;

import java.util.List;

import javax.naming.BinaryRefAddr;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.learning.sc.api.UserRegistrationDTO;
import com.learning.sc.propertyeditor.NamePropertyEditor;
import com.learning.sc.validator.EmailValidator;
import com.learning.sc.validator.UserNameValidator;

@Controller
public class RegistrationController {
	
	@Autowired
	private EmailValidator emailValidator;

	@RequestMapping("/register")
	public String showRegistrationPage(@ModelAttribute("userReg") UserRegistrationDTO dto) {
		System.out.println("Inside the showRegistrationPage method..");
		return "user-registration-page";

	}
	
	@RequestMapping("/registration-success")
	public String processUserReg(@Valid @ModelAttribute("userReg") UserRegistrationDTO dto, BindingResult result) {
		
		System.out.println("Name value enteredby user is : "+dto.getName());
		emailValidator.validate(dto, result);
		
		if(result.hasErrors()) {
			System.out.println("My page has errors ");
			List<ObjectError> allErrors = result.getAllErrors();
			
			for(ObjectError error: allErrors) {
				System.out.println(error);
			}
			return "user-registration-page";
		}
		
		System.out.println("Inside the processUserReg method..");
		return "registration-success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		System.out.println("Inside the init binder method..");
		//binder.setDisallowedFields("name");
		
		StringTrimmerEditor trimmer = new StringTrimmerEditor(true);
		binder.registerCustomEditor(String.class,"name",trimmer);
		
		NamePropertyEditor editor = new NamePropertyEditor();
		binder.registerCustomEditor(String.class, "name", editor);
		
		binder.addValidators(new UserNameValidator());
		//binder.addValidators(new EmailValidator());
	}

}
