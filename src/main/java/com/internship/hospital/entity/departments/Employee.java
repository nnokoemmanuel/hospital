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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;

@Entity
@Table(name="employees")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	
	private String employeeName;
	private String employeeTel;
	private String employeeEmail;
	private String employeeUserName;
	private String employeePassword;
	private String employeeStatus_id;
	private String employeeRole;
	
	private String userName;
	private String userSurName;
	private String userGivenName;
	private String userPassword;
	
	

	@ManyToOne
    @JoinColumn(name = "department_id")
	protected Department department;
	
	@ManyToOne
    @JoinColumn(name = "employeeStatus_id" , insertable=false, updatable=false)
	protected EmployeeStatus employeeStatus; 

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patientConsultation")
	private Set<PatientConsultation> patientConsultations;
	

	 @ManyToMany
	    @JoinTable( 
	        name = "employee_role", 
	        joinColumns = @JoinColumn(
	          name = "employee_id", referencedColumnName = "id"), 
	        inverseJoinColumns = @JoinColumn(
	          name = "role_id", referencedColumnName = "id")) 
	    private Set<Role> roles;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	



	public Employee( String employeeName, String employeeTel, String employeeEmail, String employeeUserName,
			String employeePassword, String employeeRole,  String employeeStatus_id, 
			String userName, String userSurName, String userGivenName, String userPassword) {
		super();
		
		this.userName = userName;
		this.userSurName = userSurName;
		this.userGivenName = userGivenName;
		this.userPassword = userPassword;
		
		this.employeeName = employeeName;
		this.employeeTel = employeeTel;
		this.employeeEmail = employeeEmail;
		this.employeeUserName = employeeUserName;
		this.employeePassword = employeePassword;
		this.employeeRole = employeeRole;
		this.employeeRole = employeeStatus_id;


	}




	public int getId() {
		return id;
	}




	public void setId(int id) {
		this.id = id;
	}




	public String getEmployeeName() {
		return employeeName;
	}




	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}




	public String getEmployeeTel() {
		return employeeTel;
	}




	public void setEmployeeTel(String employeeTel) {
		this.employeeTel = employeeTel;
	}




	public String getEmployeeEmail() {
		return employeeEmail;
	}




	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}




	public String getEmployeeUserName() {
		return employeeUserName;
	}




	public void setEmployeeUserName(String employeeUserName) {
		this.employeeUserName = employeeUserName;
	}




	public String getEmployeePassword() {
		return employeePassword;
	}




	public void setEmployeePassword(String employeePassword) {
		this.employeePassword = employeePassword;
	}




	public String getEmployeeStatus_id() {
		return employeeStatus_id;
	}




	public void setEmployeeStatus_id(String employeeStatus_id) {
		this.employeeStatus_id = employeeStatus_id;
	}




	public String getEmployeeRole() {
		return employeeRole;
	}




	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
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




	public String getUserPassword() {
		return userPassword;
	}




	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}




	public Department getDepartment() {
		return department;
	}




	public void setDepartment(Department department) {
		this.department = department;
	}




	public EmployeeStatus getEmployeeStatus() {
		return employeeStatus;
	}




	public void setEmployeeStatus(EmployeeStatus employeeStatus) {
		this.employeeStatus = employeeStatus;
	}




	public Set<PatientConsultation> getPatientConsultations() {
		return patientConsultations;
	}




	public void setPatientConsultations(Set<PatientConsultation> patientConsultations) {
		this.patientConsultations = patientConsultations;
	}




	public Set<Role> getRoles() {
		return roles;
	}




	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




}
