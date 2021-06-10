package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.internship.hospital.entity.departments.Cashier;
import com.internship.hospital.entity.departments.Department1;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.CashierForm;
import com.internship.hospital.form.DepartmentForm1;

public interface CashierService {

    public Cashier findById(int id);
 	public List<Cashier> findAll();
	public void updateCashier(Cashier cashier);
	public void createCashier(Cashier cashier);
	public void deleteCashier(Cashier cashier);
	public Cashier persistCashierBean(CashierForm cahsierForm,HttpServletRequest httpServletRequest) throws ParseException;
	public Cashier findByUserName(String name) ;
}
