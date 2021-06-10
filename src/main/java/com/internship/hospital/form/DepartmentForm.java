package com.internship.hospital.form;

public class DepartmentForm {

	private int id;
	private String departmentName;
	private String departmentType;
	private String departmentDescription;

	
	private DepartmentForm() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDepartmentName() {
		return departmentName;
	}


	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}


	public String getDepartmentType() {
		return departmentType;
	}


	public void setDepartmentType(String departmentType) {
		this.departmentType = departmentType;
	}


	public String getDepartmentDescription() {
		return departmentDescription;
	}


	public void setDepartmentDescription(String departmentDescription) {
		this.departmentDescription = departmentDescription;
	}
	
	
	
}
