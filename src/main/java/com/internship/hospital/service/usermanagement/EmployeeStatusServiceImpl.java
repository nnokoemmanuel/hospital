package com.internship.hospital.service.usermanagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internship.hospital.entity.departments.DeptStatus;
import com.internship.hospital.entity.departments.EmployeeStatus;
import com.internship.hospital.repository.departments.DeptStatusRepository;
import com.internship.hospital.repository.departments.EmployeeStatusRepository;


@Service("employeeStatusService")
public class EmployeeStatusServiceImpl implements EmployeeStatusService{

	@Autowired
	 private EmployeeStatusRepository employeeStatusRespository;
	
	@Override
	public EmployeeStatus findById(int id) {
		// TODO Auto-generated method stub
		return employeeStatusRespository.findById(id);
	}

	@Override
	public EmployeeStatus findByEmployeeStatusName(String employeeStatusName) {
		// TODO Auto-generated method stub
		return employeeStatusRespository.findByEmployeeStatusName( employeeStatusName);
	}

	@Override
	public List<EmployeeStatus> findAll() {
		// TODO Auto-generated method stub
		return employeeStatusRespository.findAll();
	}

	@Override
	public void deleteEmployeeStatus(EmployeeStatus employeeStatus) {
		// TODO Auto-generated method stub
		employeeStatusRespository.delete(employeeStatus);
	}

	
}
