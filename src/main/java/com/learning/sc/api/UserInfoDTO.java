package com.learning.sc.api;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class UserInfoDTO {

	@NotBlank(message = " * Your Name can't be blank")
	@Size(min = 3, max = 15, message = "{userName.size}")
	private String userName;
	
	@NotBlank(message = " * Crush Name can't be blank")
	@Size(min = 3, max = 15, message = " * Crush name should have chars between 3-15")
	private String crushName;
	
	@AssertTrue(message = "You have to agree to use our app")
	private boolean termsAndConditions;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCrushName() {
		return crushName;
	}

	public void setCrushName(String crushName) {
		this.crushName = crushName;
	}

	public boolean isTermsAndConditions() {
		return termsAndConditions;
	}

	public void setTermsAndConditions(boolean termsAndConditions) {
		this.termsAndConditions = termsAndConditions;
	}

	@Override
	public String toString() {
		return "UserInfoDTO [userName=" + userName + ", crushName=" + crushName + "]";
	}

}
