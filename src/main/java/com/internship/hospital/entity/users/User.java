package com.internship.hospital.entity.users;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id; 
	
	private String userName;
	private String userSurName;
	private String userGivenName;
	private String userEmail;
	private String userDob;
	private String userAddress;
	private String userPassword;

	
	 @ManyToMany
	    @JoinTable( 
	        name = "user_role", 
	        joinColumns = @JoinColumn(
	          name = "user_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "id")) 
	    private Set<Role> roles;
   
	 

	 public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String userName, String user_email, String user_dob, String user_address, String user_password, String userSurName, String userGivenName) {
		super();
		this.userName = userName;
		this.userEmail = user_email;
		this.userDob = user_dob;
		this.userAddress = user_address;
		this.userPassword = user_password;
		this.userSurName = userSurName;
		this.userGivenName = userGivenName;

	}

	public int getId() {
		return id;
	}

	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userDob=" + userDob
				+ ", userAddress=" + userAddress + ", roles=" + roles + "]";
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSurName() {
		return userSurName;
	}

	public void setUserSurName(String userSurName) {
		this.userSurName = userSurName;
	}

	public String getUserGivenName() {
		return userGivenName;
	}

	public void setUserGivenName(String userGivenName) {
		this.userGivenName = userGivenName;
	}
	
	
	



	
  
	
}
