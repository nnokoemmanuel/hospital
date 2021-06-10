package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.internship.hospital.entity.departments.Department;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.DepartmentForm;
import com.internship.hospital.form.UserForm;


public interface DepartmentService {
	
    public Department findById(int id);
	
	public Department findByDepartmentName(String departmentName);
	
	public Department findByDepartmentType(String departmentType);
	
	public Department findByDepartmentDescription(String departmentDescription);
	
	public List<Department> findAll();
	
	
	public void deleteDepartment(Department department);
	public void createDepartment(Department department); 
	public void updateDepartment(Department department); 
	public Department persistDepartmentBean(DepartmentForm departmentForm,HttpServletRequest httpServletRequest) throws ParseException;
			

}
