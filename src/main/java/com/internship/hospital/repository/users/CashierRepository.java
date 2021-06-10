package com.internship.hospital.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.hospital.entity.departments.Cashier;
import com.internship.hospital.entity.users.User;


@Repository("cashierRepository")
public interface CashierRepository extends JpaRepository<Cashier, String>  {
	
    public Cashier findById(int id);
	
	public Cashier findByUserName(String userName);
	
	public Cashier findByUserEmail(String userEmail);
	
	public Cashier findByUserDob(String userDob);
	
	public Cashier findByUserAddress(String userAddress);
	
	public List<Cashier> findAll();

	public Cashier findByUserGivenName(String givenName);

	public Cashier findByUserSurName(String surName);

}
