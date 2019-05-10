package com.bridgelab.microfundoo.user.DTO;


public class ForgotDTO {

	private String emailId;

	public ForgotDTO() {
		super();
	}

	public ForgotDTO(String emailId) {
		super();
		this.emailId = emailId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	@Override
	public String toString() {
		return "ForgotDto [emailId=" + emailId + "]";
	}


}

