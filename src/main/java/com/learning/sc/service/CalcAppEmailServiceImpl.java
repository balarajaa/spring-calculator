package com.learning.sc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service
public class CalcAppEmailServiceImpl implements CalcAppEmailService {
	
	@Autowired
	private JavaMailSender mailSender;

	@Override
	public void sendEmail(String userName, String userEmail, String result) {
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(userEmail);
		message.setSubject("Spring Calculator Application Result");
		message.setText("Hi" + userName + "The result predicted by Calculator is "+result);
		
		
		mailSender.send(message);
		
	}

}
