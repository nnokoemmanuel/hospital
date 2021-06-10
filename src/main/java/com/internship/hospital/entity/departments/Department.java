package com.internship.hospital.entity.departments;

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
@Table(name="Department")
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id; 
	
	private String departmentName;
	private String departmentType;
	private String departmentDescription;

	
	
	 public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String departmentName,  String departmentType, String departmentDescription) {
		super();
		this.departmentName = departmentName;
		this.departmentType = departmentType;
		this.departmentDescription = departmentDescription;

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

	@Override
	public String toString() {
		return "Department [id=" + id + ", departmentName=" + departmentName + ", departmentType=" + departmentType
				+ ", departmentDescription=" + departmentDescription + "]";
	}

	
	
	
	
}

	