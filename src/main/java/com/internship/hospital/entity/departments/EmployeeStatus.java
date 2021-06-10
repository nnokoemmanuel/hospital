package com.internship.hospital.entity.departments;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="employeeStatus")
public class EmployeeStatus {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	
	private int id; 
	private String employeeStatusName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "employeeStatus")
	private Set<Employee> employees;

	public EmployeeStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public EmployeeStatus(String employeeStatusName, Set<Employee> employees) {
		super();
		this.employeeStatusName = employeeStatusName;
		this.employees = employees;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmployeeStatusName() {
		return employeeStatusName;
	}

	public void setEmployeeStatusName(String employeeStatusName) {
		this.employeeStatusName = employeeStatusName;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	} 
	
	
}
