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

import com.internship.hospital.entity.departments.Department;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.form.DepartmentForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.UserLoginForm;

import com.internship.hospital.form.formvalidator.UserFormValidator;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.service.usermanagement.DepartmentService;
import com.internship.hospital.service.usermanagement.RoleService;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;



@Controller
public class DepartmentController {
	

	@Autowired 
	private Logger_ logger_;
	
	@Autowired
	protected UserFormValidator userFormValidator;

	@Autowired
	protected DepartmentService departmentService; 
	
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
	
	@InitBinder
    protected void initBinder(HttpServletRequest request, ServletRequestDataBinder binder) throws Exception {
	    final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    //binder.setValidator(userFormValidator);
	}
	
	
	@RequestMapping(value ="/department/list", method = RequestMethod.GET)
	public String departmentLIST(Model model){
		System.out.println("GET DEPARTMENT-LIST");
		 List<Department> department = departmentService.findAll();
		 model.addAttribute("department", department);
		return "hospital_sys/department/department_list";
		   
	}
	
	

	@RequestMapping(value = "/department/create", method = RequestMethod.GET)
	public String createGet(Model model) {
		//List<Role> allRoles = roleService.findAll();
		//model.addAttribute("allRoles", allRoles);
		return "hospital_sys/department/department_create"; //form to department 
	}
	

	@ResponseBody
	@RequestMapping(value = "/department/createpost", method = RequestMethod.POST)
	@Transactional
	public String createPost(@ModelAttribute("departmentForm") @Validated DepartmentForm departmentForm,  BindingResult result, HttpServletRequest httpServletRequest) throws ParseException {
		//User user = null;
		Department department;
		System.out.println("departmentForm "+departmentForm.getDepartmentName());
		if(result.hasErrors()){
			if(result.getFieldError("vide")!= null){
				logger_.log(Constants.NORMAL_LOG_DIR, "departmentForm form empty "+result.getFieldError("vide").getCode(),httpServletRequest);
				return result.getFieldError("vide").getCode();
				
			}
		} 
		if(departmentForm.getId() != -1 ){
			department = departmentService.persistDepartmentBean(departmentForm, httpServletRequest);
	    }else{
	    	department = departmentService.persistDepartmentBean(departmentForm, httpServletRequest);
	
	    }
	    return  "OK-"+String.valueOf(department.getId());

	}


	@RequestMapping(value = "/department/edit", method = RequestMethod.GET)
	public String editGet(Model model,@RequestParam("id") int id) {
		Department department = departmentService.findById(id);
		
		model.addAttribute("department", department);
		return "hospital_sys/department/department_edit";
	}
	
	
	@RequestMapping(value = "/department/editpost/{id}", method = RequestMethod.POST)
	public String editPost(@ModelAttribute("departmentForm") @Validated DepartmentForm departmentForm, 
			               @PathVariable("id") int id,
							BindingResult result,
							Model model,
							HttpServletRequest httpServletRequest) throws ParseException {
						
		Department department = departmentService.findById(id);
		
		System.out.println("update department"+department);
		department.getDepartmentName();
		     department.setDepartmentName(department.getDepartmentName());
		department.getDepartmentType();
		     department.setDepartmentName(department.getDepartmentType());
		department.getDepartmentDescription();
		     department.setDepartmentName(department.getDepartmentDescription());
		
		departmentService.updateDepartment(department);
		
		model.addAttribute("department", department);
		
		//redirect
		return "hospital_sys/department/department_edit";
	}
	
	
	
	@RequestMapping(value = "/department/detail", method = RequestMethod.GET)
	public String showGet(Model model,@RequestParam("id") int id) {	
	System.out.println("GET DEPT detail view");
	    Department department = departmentService.findById(id);
		model.addAttribute("department", department);
		return "hospital_sys/department/department_detail";
	}
    

	
	
	@ResponseBody
	@RequestMapping(value = "/department/delete/{id}")
	public String deleteCourse(@PathVariable int id, HttpServletRequest httpServletRequest) {
		Department department = departmentService.findById(id);
		//user.setRoles(null);
		departmentService.updateDepartment(department);
		//ArrayList<UserTracking> listeOfTrackings= userTrackingService.findByDepartment(department);
		//listeOfTrackings.forEach((tracking)->{userTrackingService.deleteUserTracking(tracking);});

		departmentService.deleteDepartment(department); 
	    logger_.log(Constants.NORMAL_LOG_DIR, "Delete the user: " + department.getDepartmentName(), httpServletRequest);		
	    return "OK";
	}

	

	
}
