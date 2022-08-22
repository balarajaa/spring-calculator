package com.learning.sc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.learning.sc.api.UserInfoDTO;

@Controller
@SessionAttributes("userInfo")
public class CalculatorController {

	@RequestMapping("/")
	public String showHomepage(Model model) {
		model.addAttribute("userInfo", new UserInfoDTO());
		return "home-page";
	}

	@RequestMapping("/process-homepage")
	public String showResultPage(Model model, @Valid UserInfoDTO userInfoDTO,
			BindingResult bindingResult) {
		
		model.addAttribute("userInfo",userInfoDTO);
		model.addAttribute(BindingResult.MODEL_KEY_PREFIX + "userInfo", bindingResult);

		if (bindingResult.hasErrors()) {

			List<ObjectError> allErrors = bindingResult.getAllErrors();
			for (ObjectError error : allErrors) {
				System.out.println(error);
			}
			return "home-page";
		}
		
		return "result-page";

	}

}
