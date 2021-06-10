package com.internship.hospital.controller.hospital.departments;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.internship.hospital.entity.departments.Department1;
import com.internship.hospital.entity.departments.Employee;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.form.DepartmentForm1;
import com.internship.hospital.form.EmployeeForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.formvalidator.EmployeeFormValidator;
import com.internship.hospital.form.formvalidator.UserFormValidator;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.service.usermanagement.DepartmentService1;
import com.internship.hospital.service.usermanagement.EmployeeService;
import com.internship.hospital.service.usermanagement.RoleService;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;

@Controller
public class EmployeeController {

	@Autowired
	private Logger_ logger_;
	@Autowired
	protected EmployeeFormValidator employeeFormValidator;

	@Autowired
	protected UserService userService;

	@Autowired
	protected RoleService roleService;

	@Autowired
	protected UserTrackingService userTrackingService;

	@Autowired
	protected UserRepository userRepository;

	@Autowired
	protected RoleRepository roleRepository;

	@Autowired
	protected EmployeeService employeeService;
	
	@Autowired
	protected DepartmentService1 departmentService;

	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    binder.setValidator(employeeFormValidator);
	}


	@RequestMapping(value = "/employee/list", method = RequestMethod.GET)
	public String listEmployee(Model model) {
		List<Employee> allEmployees = employeeService.findAll();
		model.addAttribute("employee", allEmployees);
		return "hospital_sys/employee/employee_list"; // form to create user
	}
	
	@RequestMapping(value = "/employee/create", method = RequestMethod.GET)
	public String createGet(Model model) {
		model.addAttribute("departments", departmentService.findAll());
		model.addAttribute("allRoles", roleService.findAll());
		return "hospital_sys/employee/employee_create"; // form to create user
	}


	
	 @ResponseBody 
	 @RequestMapping(value = "/employee/createpost", method = RequestMethod.POST)
	 @Transactional 
	 public String createEmployee(@ModelAttribute("employeeForm") @Validated EmployeeForm employeeForm, BindingResult result, HttpServletRequest httpServletRequest)throws ParseException { 
		 Employee employee;
	 
		 System.out.println("Employeeform "+ employeeForm.getUserGivenName());
		 if(result.hasErrors()){ if(result.getFieldError("vide")!= null){
			 logger_.log(Constants.NORMAL_LOG_DIR,"employee form empty "+result.getFieldError("vide").getCode(),httpServletRequest); 
			 return result.getFieldError("vide").getCode(); } 
		 } 
		 if(employeeForm.getId() != -1 ){ 
			 employee = employeeService.persistEmployeeBean(employeeForm, httpServletRequest);
		 }else{ 
			 employee = employeeService.persistEmployeeBean(employeeForm,httpServletRequest);
		 } 
		 return "OK-"+String.valueOf(employee.getId());
	 
	 }

	 @RequestMapping(value = "/employee/edit", method = RequestMethod.GET) 
	 public String editGet(Model model,@RequestParam("id") int id) { 
	 Employee employee =  employeeService.findById(id); 
	 Set<Role> employeeRoles= employee.getRoles();
		List<Role> listUserRole = new ArrayList<Role>(employeeRoles);
		List<Role> allRoles = roleService.findAll();
		List<Role> remainingRoles = allRoles;
		remainingRoles.removeAll(listUserRole);

		model.addAttribute("employeeRoles", employeeRoles);
		model.addAttribute("remainingRoles", remainingRoles);
		model.addAttribute("departments", departmentService.findAll());
		model.addAttribute("employeeDepartment", employee.getDepartment());
		model.addAttribute("employee", employee);
	  return "hospital_sys/employee/employee_edit"; }
	 
	 
	 @RequestMapping(value = "/employee/detail", method = RequestMethod.GET)
	 public String showGet(Model model,@RequestParam("id") int id) {
	 //@RequestMapping(value = "/employee/detail/{id}", method = RequestMethod.GET) 
	 //public String showGet(Model model,@PathVariable int id){
	  Employee employee = employeeService.findById(id);
	  model.addAttribute("employee", employee); 
	  return "hospital_sys/employee/employee_detail"; 
	 }
	  
 
	 @ResponseBody
     @RequestMapping(value = "/employee/delete/{id}") 
	 public String deleteEmployee(@PathVariable int id, HttpServletRequest httpServletRequest){
		 Employee employee = employeeService.findById(id);
	   //ArrayList<UserTracking> listeOfTrackings=userTrackingService.findByUser(user);
	   //listeOfTrackings.forEach((tracking)->{userTrackingService.deleteUserTracking(tracking);});
	   if(employee.getPatientConsultations().size() > 0)
		   return "KO";
	   employeeService.deleteEmployee(employee);
	   logger_.log(Constants.NORMAL_LOG_DIR,"Delete the employee: " + employee.getId(), httpServletRequest); 
	   return "OK"; 
	  }


}
