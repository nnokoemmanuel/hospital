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
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.form.DepartmentForm1;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.formvalidator.DepartmentFormValidator1;
import com.internship.hospital.form.formvalidator.UserLoginValidator;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.service.usermanagement.DepartmentService1;
import com.internship.hospital.service.usermanagement.RoleService;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;

@Controller
public class DepartmentController1 {

	@Autowired
	private Logger_ logger_;
	@Autowired
	protected DepartmentFormValidator1 departmentFormValidator;

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
	protected DepartmentService1 departmentService;


	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    binder.setValidator(departmentFormValidator);
	}

	@RequestMapping(value = "//department1/create", method = RequestMethod.GET)
	public String createGet1(Model model) {
		return "hospital_sys/department_create"; // form to create user
	}

	@RequestMapping(value = "//department1/list", method = RequestMethod.GET)
	public String listDepartment1(Model model) {
		List<Department1> allDepartments = departmentService.findAll();
		model.addAttribute("departments", allDepartments);
		return "hospital_sys/department_list"; // form to create user
	}

	
	 @ResponseBody 
	 @RequestMapping(value = "//department1/createpost", method = RequestMethod.POST)
	 @Transactional 
	 public String createDepartment1(@ModelAttribute("departmentForm") @Validated DepartmentForm1 departmentForm, BindingResult result, HttpServletRequest httpServletRequest)throws ParseException { 
		 Department1 department;
	 
		 System.out.println("departmentform "+ departmentForm.getDeptName());
		 if(result.hasErrors()){ if(result.getFieldError("vide")!= null){
			 logger_.log(Constants.NORMAL_LOG_DIR,"user form empty "+result.getFieldError("vide").getCode(),httpServletRequest); 
			 return result.getFieldError("vide").getCode(); } 
		 } 
		 if(departmentForm.getId() != -1 ){ 
			 department = departmentService.persistDepartmentBean(departmentForm, httpServletRequest);
		 }else{ 
			 department = departmentService.persistDepartmentBean(departmentForm,httpServletRequest);
		 } 
		 return "OK-"+String.valueOf(department.getId());
	 
	 }

	 @RequestMapping(value = "//department/edit", method = RequestMethod.GET) 
	 public String editGet1(Model model,@RequestParam("id") int id) { 
     Department1 department =  departmentService.findById(id); 
	 model.addAttribute("department", department);
	  return "hospital_sys/departments/department_edit"; }
	 
	 @RequestMapping(value = "//department/detail/{id}", method = RequestMethod.GET) 
	 public String showGet1(Model model,@PathVariable int id){
	  Department1 department = departmentService.findById(id);
	  model.addAttribute("department", department); 
	  return "hospital_sys/departments/department_detail"; 
	 }
	  
 
	 @ResponseBody
     @RequestMapping(value = "//department1/delete/{id}") 
	 public String deleteDepartment1(@PathVariable int id, HttpServletRequest httpServletRequest){
	   Department1 department = departmentService.findById(id);
	   //ArrayList<UserTracking> listeOfTrackings=userTrackingService.findByUser(user);
	   //listeOfTrackings.forEach((tracking)->{userTrackingService.deleteUserTracking(tracking);});
	   if(department.getEmployees().size() > 0)
		   return "KO";
	   departmentService.deleteDepartment(department);
	   logger_.log(Constants.NORMAL_LOG_DIR,"Delete the department: " + department.getId(), httpServletRequest); 
	   return "OK"; 
	  }


}
