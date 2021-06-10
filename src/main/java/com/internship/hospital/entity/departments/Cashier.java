package com.internship.hospital.entity.departments;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.internship.hospital.entity.users.Role;

@Entity
@Table(name="cashier")
public class Cashier extends Employee{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
    private String employeeTel;
	
	private String userName;
	private String userSurName;
	private String userGivenName;
	private String userEmail;
	private String userDob;
	private String userAddress;
	private String userPassword; 
	
	//private String payment_status_id;
	

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cashier")
	private Set<PaymentInfo> paymentInfos;
	
	 @ManyToMany
	    @JoinTable( 
	        name = "cashier_role", 
	        joinColumns = @JoinColumn(name = "cashier_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")) 
	    private Set<Role> roles;


	public Cashier() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Cashier(String employeeTel, String userName, String userSurName, String userGivenName,
			String userEmail, String userDob, String userAddress, String userPassword) {
		super();
		
		this.employeeTel = employeeTel;
		this.userName = userName;
		this.userSurName = userSurName;
		this.userGivenName = userGivenName;
		this.userEmail = userEmail;
		this.userDob = userDob;
		this.userAddress = userAddress;
		this.userPassword = userPassword;
		
	}





	public String getEmployeeTel() {
		return employeeTel;
	}





	public void setEmployeeTel(String employeeTel) {
		this.employeeTel = employeeTel;
	}





	public String getUserName() {
		return userName;
	}





	public void setUserName(String userName) {
		this.userName = userName;
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





	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Set<PaymentInfo> getPaymentInfos() {
		return paymentInfos;
	}


	public void setPaymentInfos(Set<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}


	
}
