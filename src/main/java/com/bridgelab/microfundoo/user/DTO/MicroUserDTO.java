package com.bridgelab.microfundoo.user.DTO;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Transient;
import org.springframework.format.annotation.DateTimeFormat;


public class  MicroUserDTO{
	private String firstName;
	private String lastName;
	//@Email(regexp="^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.(?:[A-Z]{2,}|com|org))+$",message="Not valid")
	@Column(unique=true, nullable=false)
	private static String email;
	@Transient
	private String password;
	private String confirmPassword;
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	private String mobileNumber;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime created_date;

	public LocalDateTime getCreated_date() {
		return created_date;
	}
	public void setCreated_date(LocalDateTime created_date) {
		this.created_date = created_date;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String name) {
		this.firstName=name;
	}
	public void setLastName(String name) {
		this.lastName=name;
	}
	public String getLastName() {
		return lastName;
	}
	public  String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
}

