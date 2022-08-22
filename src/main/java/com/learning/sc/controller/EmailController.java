package com.learning.sc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.learning.sc.api.EmailDTO;
import com.learning.sc.api.UserInfoDTO;
import com.learning.sc.service.CalcAppEmailService;
import com.learning.sc.service.CalcAppEmailServiceImpl;

@Controller
public class EmailController {
	
	@Autowired
	private CalcAppEmailServiceImpl calcService;
	
	@RequestMapping("/sendEmail")
	public String sendEmail(Model model) {
		model.addAttribute("emailDTO", new EmailDTO());
		//model.addAttribute("userName", userName.toUpperCase());
		return "send-email-page";
		
	}
	
	@RequestMapping("/process-email")
	public String processEmail(@SessionAttribute("userInfo") UserInfoDTO userInfoDTO, @ModelAttribute("emailDTO") EmailDTO emailDTO) {
		calcService.sendEmail(userInfoDTO.getUserName(),emailDTO.getUserEmail(),"FRIEND");
		return "process-email-page";
		
	}

}
