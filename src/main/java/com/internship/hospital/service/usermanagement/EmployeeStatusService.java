package com.internship.hospital.service.usermanagement;

import java.util.List;
import com.internship.hospital.entity.departments.DeptStatus;
import com.internship.hospital.entity.departments.EmployeeStatus;

public interface EmployeeStatusService {

	public EmployeeStatus findById(int id);
	
	public EmployeeStatus findByEmployeeStatusName(String employeeStatusName);
	
	public List<EmployeeStatus> findAll();
	
	public void deleteEmployeeStatus(EmployeeStatus EmployeeStatus);

	
}
