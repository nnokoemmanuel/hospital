package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.internship.hospital.entity.departments.Department1;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.DepartmentForm1;

public interface DepartmentService1 {

public Department1 findById(int id);
	
	
	
	public Department1 findByDeptName(String deptName);
	
	public List<Department1> findAll();
	public void updateDepartment(Department1 department);
	public void createDepartment(Department1 department);
	public void deleteDepartment(Department1 department);
	public Department1 persistDepartmentBean(DepartmentForm1 departmentForm,HttpServletRequest httpServletRequest) throws ParseException;
}
