package com.internship.hospital.repository.departments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.hospital.entity.departments.Department;
import com.internship.hospital.entity.users.User;


@Repository("departmentRepository")
public interface DepartmentRepository extends JpaRepository<Department, String>  {
	
	  public Department findById(int id);
		
		public Department findByDepartmentName(String departmentName);
		
		public Department findByDepartmentType(String departmentType);
		
		public Department findByDepartmentDescription(String departmentDescription);
		
		public List<Department> findAll();

}
