package com.internship.hospital.form;

public class UserLoginForm {


	private String userName;
	private String userPassword;


	private UserLoginForm() {
		super();
		// TODO Auto-generated constructor stub
	}

	private UserLoginForm(String userName, String userPassword) {
		super();
		this.userName = userName;
		this.userPassword = userPassword;
	
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	
	
}
