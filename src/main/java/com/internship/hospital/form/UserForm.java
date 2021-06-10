package com.internship.hospital.form;

public class UserForm {

	private int id;
	protected String userName;
	protected String UserSurName;
	protected String UserGivenName;
	protected String userEmail;
	protected String userDob;
	protected String userAddress;
	protected String userPassword;
	protected String userRole;

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public UserForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserSurName() {
		return UserSurName;
	}

	public void setUserSurName(String userSurName) {
		UserSurName = userSurName;
	}

	public String getUserGivenName() {
		return UserGivenName;
	}

	public void setUserGivenName(String userGivenName) {
		UserGivenName = userGivenName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserDob() {
		return userDob;
	}

	public void setUserDob(String userDob) {
		this.userDob = userDob;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	

	
}
