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
import com.internship.hospital.entity.departments.Employee;
import com.internship.hospital.entity.departments.EmployeeStatus;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.CashierForm;
import com.internship.hospital.form.DepartmentForm1;
import com.internship.hospital.form.EmployeeForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.repository.departments.DepartmentRepository1;
import com.internship.hospital.repository.users.CashierRepository;
import com.internship.hospital.repository.users.EmployeeRepository;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;
import com.internship.hospital.util.Tracker;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {


	@Autowired
	  private EmployeeRepository employeeRepository;
	
	@Autowired
	  private EmployeeStatusService employeeStatusService;
	
	@Autowired
	 private EmployeeService employeeService;
	
	
	@Autowired
	 private DepartmentService departmentService;
	
	@Autowired
	 private RoleService roleService;
	
	@Autowired 
	private Logger_ logger_;
	

	@Autowired
	private Tracker tracker;
	
	
	@Override
	public List<Employee> findAll(){
		return employeeRepository.findAll();
	}
	
	@Override
	public Employee findById(int id){
		return employeeRepository.findById(id);
	}
	


	@Override
	public void deleteEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeRepository.delete(employee);
	}
	
	/**
	 * convert a form to bean
	 * @return
	 */
	@Override
	public Employee persistEmployeeBean(EmployeeForm employeeForm,HttpServletRequest httpServletRequest) throws ParseException{

		Employee employee;	
		if(employeeForm.getId() ==0  ){
		    //case Employee does not exists yet
			//we create Employee
			EmployeeStatus employeeStatus = employeeStatusService.findByEmployeeStatusName("ASSIGNED");
			employee = new Employee(  employeeForm.getEmployeeName(),employeeForm.getEmployeeTel(),employeeForm.getEmployeeEmail(),
					                employeeForm.getEmployeeUserName(),employeeForm.getEmployeePassword(), employeeForm.getEmployeeRole(),
					                employeeForm.getUserName(),employeeForm.getUserSurName(),employeeForm.getUserGivenName(), 
					                employeeForm.getUserPassword(), null) ;
			
			createEmployee(employee);
			
			Department department = departmentService.findById(employeeForm.getDepartmentId());
			employee.setDepartment(department);
			employee.setEmployeeStatus(employeeStatus);
			String[] selectedRoles = employeeForm.getUserRole().split(",");
			Set<Role> rolesToPersist = new HashSet();
			for(String userRole : selectedRoles){
				Role role = roleService.findById(Integer.parseInt(userRole));
				if(role != null){
					rolesToPersist.add(role);
				}
				
			}
			employee.setRoles(rolesToPersist);
			employeeService.updateEmployee(employee);
			updateEmployee(employee);
			
			tracker.track(employee, "REGISTERED THE EMPLOYEE" , httpServletRequest);
			logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the Employee Registration: "+employee.getUserName());	
			return employee;
			
		}else{
			Employee employeeToEdit = employeeService.findById(employeeForm.getId());
			Department department = departmentService.findById(employeeForm.getDepartmentId());
			employeeToEdit.setDepartment(department);
			employeeToEdit.setEmployeeName(employeeForm.getEmployeeName());
			employeeToEdit.setEmployeeTel(employeeForm.getEmployeeTel());
			employeeToEdit.setEmployeeEmail(employeeForm.getEmployeeEmail());
			employeeToEdit.setEmployeeUserName(employeeForm.getEmployeeUserName());
			employeeToEdit.setEmployeePassword(employeeForm.getEmployeePassword());
			employeeToEdit.setEmployeeRole(employeeForm.getEmployeeRole());
			
			employeeToEdit.setUserGivenName(employeeForm.getUserGivenName());
			employeeToEdit.setUserSurName(employeeForm.getUserSurName());
			employeeToEdit.setUserPassword(employeeForm.getUserPassword());
			
			String[] selectedRoles = employeeForm.getUserRole().split(",");
			Set<Role> rolesToPersist = new HashSet();
			for(String userRole : selectedRoles){
				Role role = roleService.findById(Integer.parseInt(userRole));
				if(role != null){
					rolesToPersist.add(role);
				}
				
			}
			employeeToEdit.setRoles(rolesToPersist);
			updateEmployee(employeeToEdit);
            
			tracker.track(employeeToEdit, "EDITED THE EMPLOYEE " , httpServletRequest);
    		logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the cashier Edition: "+employeeToEdit.getId());
			return employeeToEdit;
		}
	}
	
	@Override
	public void createEmployee(Employee employee) {
		employeeRepository.save(employee);
		
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		employeeRepository.saveAndFlush(employee);

	}
	
	@Override
	public Employee findByUserName(String name) {
		return employeeRepository.findByUserName(name);
	}
}
