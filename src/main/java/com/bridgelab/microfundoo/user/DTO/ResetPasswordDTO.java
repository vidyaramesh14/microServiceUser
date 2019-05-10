package com.bridgelab.microfundoo.user.DTO;

public class ResetPasswordDTO {

	private String re_password;
	private String confirm_password;

	public String getConfirm_password() {
		return confirm_password;
	}
	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}
	public ResetPasswordDTO() {
		super();	
	}
	public String getRe_password() {
		return re_password;
	}
	public void setRe_password(String re_password) {
		this.re_password = re_password;
	}
	public ResetPasswordDTO(String re_password) {
		super();
		this.re_password = re_password;
	}@Override
	public String toString() {
		return "ResetPasswordDTO [re_password=" + re_password + ", confirm_password=" + confirm_password + "]";
	}

}


