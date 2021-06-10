package com.internship.hospital.controller.users;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internship.hospital.entity.departments.Cashier;
import com.internship.hospital.entity.departments.Employee;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.UserLoginForm;
import com.internship.hospital.form.formvalidator.UserLoginValidator;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.service.usermanagement.CashierService;
import com.internship.hospital.service.usermanagement.EmployeeService;
import com.internship.hospital.service.usermanagement.RoleService;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import java.text.SimpleDateFormat;



@Controller
public class LoginController {
	

	@Autowired 
	private Logger_ logger_;
	
	@Autowired
	protected UserLoginValidator userLoginValidator;

	@Autowired
	protected UserService userService; 
	
	@Autowired
	protected RoleService roleService;
	
	@Autowired
	protected EmployeeService employeeService; 
	
	@Autowired
	protected CashierService cashierService;

	@Autowired
	protected UserTrackingService userTrackingService;
	
	@Autowired
	protected UserRepository userRepository; 
	
	@Autowired
	protected RoleRepository roleRepository;
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    binder.setValidator(userLoginValidator);
	}
	
	@ResponseBody
	@RequestMapping(value ="/checkLoginUser", method = RequestMethod.POST) 
	public String checkLoginUser(@ModelAttribute("userLoginForm") @Validated UserLoginForm userLoginForm,  BindingResult result,Model model,HttpServletRequest httpServletRequest) {
		  
		if(result.hasErrors()){
			if(result.getFieldError("username")!=null){
				return result.getFieldError("username").getCode();
			}
			if(result.getFieldError("userpassword")!=null){
				return result.getFieldError("userpassword").getCode();
			}
		}
		
	    User userInDatabase = userService.findByUserName(userLoginForm.getUserName());//check if user from login exists in database
	    if(userInDatabase !=null){
	    	return checkUserTable( userInDatabase ,  userLoginForm);
	    }	
	    else{
	    	Employee employeeInDatabase = employeeService.findByUserName(userLoginForm.getUserName());
	    	if(userInDatabase !=null)
	    		return checkEmployeeTable( employeeInDatabase ,  userLoginForm);
	    	else {
		    	Cashier cashierInDatabase = cashierService.findByUserName(userLoginForm.getUserName());
		    	if(cashierInDatabase !=null)
		    		return checkEmployeeTable( cashierInDatabase ,  userLoginForm);
	    	}
	    	
	    	return "connection.deny.user.not.exist";//if the user does not exits in database refuse connection.
	    
	    }	
		
	}
	
	@RequestMapping(value ="/homeAdmin", method = RequestMethod.GET) 
	public String homeView(Model model,HttpServletRequest httpServletRequest) {
		List<User> users=userService.findAll();
		model.addAttribute("users", users);
		return "hospital_sys/homeAdmin";
		
	}
	
	
	private String checkUserTable(User userInDatabase , UserLoginForm userLoginForm){
		Set<Role> rolesOfUser = userInDatabase.getRoles();//gets roles of user
    	if (rolesOfUser.size() ==0){
    		return "connection.deny.user.not.having.role";
    		
    	}	
    	else{
    		if(userInDatabase.getUserPassword().equals(userLoginForm.getUserPassword())){

    			Role roleAdmin = roleService.findByRoleName("ROLE_ADMINISTRATOR");
    			if(userInDatabase.getRoles().contains(roleAdmin)){

    				return "connection.granted@ROLE_ADMINISTRATOR@"+userInDatabase.getUserSurName()+"@"+userInDatabase.getUserGivenName();
    			}
    			return null;
    			
    		}else {
    			return "connection.denied.wrong.password";
    		}
    	}
		
	}
	
	private String checkEmployeeTable(Employee userInDatabase , UserLoginForm userLoginForm){
		Set<Role> rolesOfUser = userInDatabase.getRoles();//gets roles of user
    	if (rolesOfUser.size() ==0){
    		return "connection.deny.user.not.having.role";
    		
    	}	
    	else{
    		if(userInDatabase.getUserPassword().equals(userLoginForm.getUserPassword())){

    			Role roleAdmin = roleService.findByRoleName("ROLE_ADMINISTRATOR");
    			if(userInDatabase.getRoles().contains(roleAdmin)){

    				return "connection.granted@ROLE_ADMINISTRATOR@"+userInDatabase.getUserSurName()+"@"+userInDatabase.getUserGivenName();
    			}
    			return null;
    			
    		}else {
    			return "connection.denied.wrong.password";
    		}
    	}
		
	}
	
	private String checkCashierTable(Cashier userInDatabase , UserLoginForm userLoginForm){
		Set<Role> rolesOfUser = userInDatabase.getRoles();//gets roles of user
    	if (rolesOfUser.size() ==0){
    		return "connection.deny.user.not.having.role";
    		
    	}	
    	else{
    		if(userInDatabase.getUserPassword().equals(userLoginForm.getUserPassword())){

    			Role roleAdmin = roleService.findByRoleName("ROLE_ADMINISTRATOR");
    			if(userInDatabase.getRoles().contains(roleAdmin)){

    				return "connection.granted@ROLE_ADMINISTRATOR@"+userInDatabase.getUserSurName()+"@"+userInDatabase.getUserGivenName();
    			}
    			return null;
    			
    		}else {
    			return "connection.denied.wrong.password";
    		}
    	}
		
	}

	
	

	
}
