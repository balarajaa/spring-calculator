package com.learning.sc.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.learning.sc.api.Phone;

public class PhoneNumberFormatter implements Formatter<Phone> {

	@Override
	public String print(Phone object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Phone parse(String completePhoneNumber, Locale locale) throws ParseException {
		String[] phoneNumber = completePhoneNumber.split("-");
		Phone phone = new Phone();

		int index = completePhoneNumber.indexOf("-");
		if (index == -1 || completePhoneNumber.startsWith("-")) {
			phone.setCountryCode("91");
			if (completePhoneNumber.startsWith("-")) {
				phone.setUserNumber(phoneNumber[1]);
			} else {
				phone.setUserNumber(phoneNumber[0]);
			}
		} else {
			phone.setCountryCode(phoneNumber[0]);
			phone.setUserNumber(phoneNumber[1]);

		}
		return phone;
	}

}
