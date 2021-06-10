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
import com.internship.hospital.form.RoleForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.formvalidator.EmployeeFormValidator;
import com.internship.hospital.form.formvalidator.RoleFormValidator;
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
public class RoleController {

	@Autowired
	private Logger_ logger_;
	@Autowired
	protected RoleFormValidator roleFormValidator;

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

	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    binder.setValidator(roleFormValidator);
	}

	@RequestMapping(value = "/role/create", method = RequestMethod.GET)
	public String createGet(Model model) {
		return "hospital_sys/role_create"; // form to create role
	}

	@RequestMapping(value = "/role/list", method = RequestMethod.GET)
	public String listRole(Model model) {
		List<Role> allRoles = roleService.findAll();
		model.addAttribute("roles", allRoles);
		return "hospital_sys/role_list"; //  to list role
	}

	
	 @ResponseBody 
	 @RequestMapping(value = "/role/createpost", method = RequestMethod.POST)
	 @Transactional 
	 public String createRole(@ModelAttribute("roleForm") @Validated RoleForm roleForm, BindingResult result, HttpServletRequest httpServletRequest)throws ParseException { 
		 Role role;
	 
		 System.out.println("Roleform "+ roleForm.getRoleName());
		 if(result.hasErrors()){ if(result.getFieldError("vide")!= null){
			 logger_.log(Constants.NORMAL_LOG_DIR,"employee form empty "+result.getFieldError("vide").getCode(),httpServletRequest); 
			 return result.getFieldError("vide").getCode(); } 
		 } 
		 if(roleForm.getId() != -1 ){ 
			 role = roleService.persistRoleBean(roleForm, httpServletRequest);
		 }else{ 
			 role = roleService.persistRoleBean(roleForm,httpServletRequest);
		 } 
		 return "OK-"+String.valueOf(role.getId());
	 
	 }

	 @RequestMapping(value = "/role/edit", method = RequestMethod.GET) 
	 public String editGet(Model model,@RequestParam("id") int id) { 
	 Role role =  roleService.findById(id); 
	 model.addAttribute("role", role);
	  return "hospital_sys/roles/role_edit"; }
	 
	 @RequestMapping(value = "/role/detail/{id}", method = RequestMethod.GET) 
	 public String showGet(Model model,@PathVariable int id){
	  Role role = roleService.findById(id);
	  model.addAttribute("role", role); 
	  return "hospital_sys/roles/role_detail"; 
	 }
	  
 
	 @ResponseBody
     @RequestMapping(value = "/role/delete/{id}") 
	 public String deleteEmployee(@PathVariable int id, HttpServletRequest httpServletRequest){
		 Role role = roleService.findById(id);
	   //ArrayList<UserTracking> listeOfTrackings=userTrackingService.findByUser(user);
	   //listeOfTrackings.forEach((tracking)->{userTrackingService.deleteUserTracking(tracking);});
	   if(role.getUsers().size() > 0)
		   return "KO";
	   roleService.deleteRole(role);
	   logger_.log(Constants.NORMAL_LOG_DIR,"Delete the role: " + role.getId(), httpServletRequest); 
	   return "OK"; 
	  }


}
