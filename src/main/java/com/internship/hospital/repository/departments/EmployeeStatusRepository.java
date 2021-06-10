package com.internship.hospital.repository.departments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.internship.hospital.entity.departments.DeptStatus;
import com.internship.hospital.entity.departments.EmployeeStatus;

@Repository("employeeStatusRepository")
public interface EmployeeStatusRepository extends JpaRepository<EmployeeStatus, String>{

	public EmployeeStatus findById(int id);
	
	public EmployeeStatus findByEmployeeStatusName(String employeeStatusName);
	
	public List<EmployeeStatus> findAll();
	
}
