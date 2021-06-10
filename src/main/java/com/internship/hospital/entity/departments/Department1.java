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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="departments")
public class Department1 {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	
	private int id; 
	private String deptName;
	
	
	
	@ManyToOne
    @JoinColumn(name = "deptStatus_id")
    private DeptStatus deptStatus;
	
	 @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "department")
		private Set<Employee> employees; 


	public Department1() {
		super();
		// TODO Auto-generated constructor stub
	}

	

		public Department1(String deptName, DeptStatus deptStatus) {
		super();
		this.deptName = deptName;
		this.deptStatus = deptStatus;
		}
		

		//getters and setters
		public int getId() {
			return id;
		}


		public void setId(int id) {
			this.id = id;
		}
	
	public String getDeptName() {
		return deptName;
	}


	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}





	public DeptStatus getDeptStatus() {
		return deptStatus;
	}



	public void setDeptStatus(DeptStatus deptStatus) {
		this.deptStatus = deptStatus;
	}



	public Set<Employee> getEmployees() {
		return employees;
	}



	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	
}
