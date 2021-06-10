package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.internship.hospital.entity.departments.Cashier;
import com.internship.hospital.entity.departments.Department1;
import com.internship.hospital.entity.departments.Employee;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.CashierForm;
import com.internship.hospital.form.DepartmentForm1;
import com.internship.hospital.form.EmployeeForm;

public interface EmployeeService {

    public Employee findById(int id);
 	public List<Employee> findAll();
	public void updateEmployee(Employee Employee);
	public void createEmployee(Employee employee);
	public void deleteEmployee(Employee employee);
	public Employee persistEmployeeBean(EmployeeForm employeeForm,HttpServletRequest httpServletRequest) throws ParseException;
	public Employee findByUserName(String name) ;
}
