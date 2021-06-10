package com.internship.hospital.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.hospital.entity.departments.Cashier;
import com.internship.hospital.entity.departments.Employee;
import com.internship.hospital.entity.users.User;


@Repository("employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee, String>  {
	
    public Employee findById(int id);
	
	public Employee findByUserName(String userName);
	
	//public Employee findByUserEmail(String userEmail);
	
	//public Employee findByUserDob(String userDob); 
	
	//public Employee findByUserAddress(String userAddress);
	
	public List<Employee> findAll();

	public Employee findByUserGivenName(String givenName);

	public Employee findByUserSurName(String surName);

}
