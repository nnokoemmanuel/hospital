package com.internship.hospital.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.hospital.entity.users.User;


@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, String>  {
	
public User findById(int id);
	
	public User findByUserName(String userName);
	
	public User findByUserEmail(String userEmail);
	
	public User findByUserDob(String userDob);
	
	public User findByUserAddress(String userAddress);
	
	public List<User> findAll();

	public User findByUserGivenName(String givenName);

	public User findByUserSurName(String surName);

}
