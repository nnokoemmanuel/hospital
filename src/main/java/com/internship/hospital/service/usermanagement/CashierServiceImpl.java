package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.internship.hospital.entity.departments.Cashier;
import com.internship.hospital.entity.departments.Department;
import com.internship.hospital.entity.departments.Department1;
import com.internship.hospital.entity.departments.DeptStatus;
import com.internship.hospital.entity.departments.EmployeeStatus;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.CashierForm;
import com.internship.hospital.form.DepartmentForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.repository.departments.DepartmentRepository;
import com.internship.hospital.repository.users.CashierRepository;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;
import com.internship.hospital.util.Tracker;

@Service("cashierService")
public class CashierServiceImpl implements CashierService {


	@Autowired
	  private CashierRepository cashierRepository;
	
	@Autowired
	  private DeptStatusService departmentStatusService;
	
	@Autowired
	 private CashierService cashierService;
	
	@Autowired
	 private EmployeeStatusService employeeStatusService;
	
	@Autowired
	 private DepartmentService departmentService;
	
	@Autowired 
	private Logger_ logger_;
	

	@Autowired
	private Tracker tracker;
	
	
	@Override
	public List<Cashier> findAll(){
		return cashierRepository.findAll();
	}
	
	@Override
	public Cashier findById(int id){
		return cashierRepository.findById(id);
	}
	


	@Override
	public void deleteCashier(Cashier cashier) {
		// TODO Auto-generated method stub
		cashierRepository.delete(cashier);
	}
	
	/**
	 * convert a form to bean
	 * @return
	 */
	@Override
	public Cashier persistCashierBean(CashierForm cashierForm,HttpServletRequest httpServletRequest) throws ParseException{

		Cashier cashier;	
		if(cashierForm.getId() ==0  ){ 
		    //case department does not exists yet
			//we create department
			EmployeeStatus employeeStatus = employeeStatusService.findByEmployeeStatusName("ASSIGNED");
			cashier = new Cashier(cashierForm.getEmployeeTel(), cashierForm.getEmployeeTel(), cashierForm.getUserSurName(), cashierForm.getUserGivenName(),
					cashierForm.getUserEmail(), cashierForm.getUserDob(), cashierForm.getUserAddress(), cashierForm.getUserPassword());
			
			createCashier(cashier);
			tracker.track(cashier, "REGISTERED THE CASHIER" , httpServletRequest);
			logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the cashier Registration: "+cashier.getUserName());	
			Department department = departmentService.findById(cashierForm.getDepartmentId());
			cashier.setDepartment(department);
			cashier.setEmployeeStatus(employeeStatus);
			updateCashier(cashier);
			return cashier;
			
		}else{
			Cashier cashierToEdit = cashierService.findById(cashierForm.getId());
			Department department = departmentService.findById(cashierForm.getDepartmentId());
			cashierToEdit.setDepartment(department);
			cashierToEdit.setEmployeeTel(cashierForm.getEmployeeTel());
			cashierToEdit.setUserAddress(cashierForm.getUserAddress());
			cashierToEdit.setUserDob(cashierForm.getUserDob());
			cashierToEdit.setUserEmail(cashierForm.getUserEmail());
			cashierToEdit.setUserGivenName(cashierForm.getUserGivenName());
			cashierToEdit.setUserName(cashierForm.getUserName());
			cashierToEdit.setUserPassword(cashierForm.getUserPassword());
			cashierToEdit.setUserSurName(cashierForm.getUserSurName());
            updateCashier(cashierToEdit);
            
			tracker.track(cashierToEdit, "EDITED THE CASHIER " , httpServletRequest);
    		logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the cashier Edition: "+cashierToEdit.getId());
			return cashierToEdit;
		}
	}
	
	@Override
	public void createCashier(Cashier cashier) {
		cashierRepository.save(cashier);
		
	}
	
	@Override
	public void updateCashier(Cashier cashier) {
		cashierRepository.saveAndFlush(cashier);

	}
	
	@Override
	public Cashier findByUserName(String name) {
		return cashierRepository.findByUserName(name);
	}
}
