package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.UserForm;

public interface UserService {
	
    public User findById(int id);
	
	public User findByUserName(String name);
	
	public User findByUserGivenName(String givenName);
	
	public User findByUserSurName(String surName);
	
	public User findByUserEmail(String email);
	
	public User findByUserDob(String dob);
	
	public User findByUserAddress(String address);

	public List<User> findAll();
	
	public void deleteUser(User user);
	public void createUser(User user); 
	public void updateUser(User user); 
	public User persistUserBean(UserForm userForm,HttpServletRequest httpServletRequest) throws ParseException;
			

}
