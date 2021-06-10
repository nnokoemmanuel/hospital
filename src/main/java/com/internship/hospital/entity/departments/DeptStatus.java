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
@Table(name="deptStatus")
public class DeptStatus {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String deptStatusName;
	 
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "deptStatus")
	private Set<Department1> department;

	public DeptStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DeptStatus(String deptStatusName, Set<Department1> department) {
		super();
		this.deptStatusName = deptStatusName;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDeptStatusName() {
		return deptStatusName;
	}

	public void setDeptStatusName(String deptStatusName) {
		this.deptStatusName = deptStatusName;
	}

	public Set<Department1> getDepartment() {
		return department;
	}

	public void setDepartment(Set<Department1> department) {
		this.department = department;
	} 

    
	
}
