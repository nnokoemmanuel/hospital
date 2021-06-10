package com.internship.hospital.controller.users;

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

import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.formvalidator.UserFormValidator;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.service.usermanagement.RoleService;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;



@Controller
public class UserController {
	

	@Autowired 
	private Logger_ logger_;
	
	@Autowired
	protected UserFormValidator userFormValidator;

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
	
	

	

	@RequestMapping(value = "/user/create", method = RequestMethod.GET)
	public String createGet(Model model) {
		List<Role> allRoles = roleService.findAll();
		model.addAttribute("allRoles", allRoles);
		return "hospital_sys/users/user_create"; //form to create user
	}
	

	@ResponseBody
	@RequestMapping(value = "/user/createpost", method = RequestMethod.POST)
	@Transactional
	public String createCourse(@ModelAttribute("userForm") @Validated UserForm userForm,  BindingResult result, HttpServletRequest httpServletRequest) throws ParseException {
		//User user = null;
		User user;
		System.out.println("userform "+userForm.getUserName());
		if(result.hasErrors()){
			if(result.getFieldError("vide")!= null){
				logger_.log(Constants.NORMAL_LOG_DIR, "user form empty "+result.getFieldError("vide").getCode(),httpServletRequest);
				return result.getFieldError("vide").getCode();
				
			}
		} 
		if(userForm.getId() != -1 ){
			user = userService.persistUserBean(userForm, httpServletRequest);
	    }else{
	    	user = userService.persistUserBean(userForm, httpServletRequest);
	
	    }
	    return  "OK-"+String.valueOf(user.getId());

	}


	@RequestMapping(value = "/user/edit", method = RequestMethod.GET)
	public String editGet(Model model,@RequestParam("id") int id) {
		User user = userService.findById(id);
		Set<Role> userRoles= user.getRoles();
		List<Role> listUserRole = new ArrayList<Role>(userRoles);
		List<Role> allRoles = roleService.findAll();
		List<Role> remainingRoles = allRoles;
		remainingRoles.removeAll(listUserRole);

		model.addAttribute("userRoles", userRoles);
		model.addAttribute("remainingRoles", remainingRoles);
		model.addAttribute("user", user);
		return "hospital_sys/users/user_edit";
	}
	
	//@RequestMapping(value = "/user/detail/{userId}", method = RequestMethod.GET)
	//public String showGet(Model model,@PathVariable int id) {
	@RequestMapping(value = "/user/detail", method = RequestMethod.GET)
	public String showGet(Model model,@RequestParam("id") int id) {	
	System.out.println("detail view");
		User user = userService.findById(id);
		model.addAttribute("user", user);
		return "hospital_sys/users/user_detail";
	}
    

	
	
	@ResponseBody
	@RequestMapping(value = "/user/delete/{id}")
	public String deleteCourse(@PathVariable int id, HttpServletRequest httpServletRequest) {
		User user = userService.findById(id);
		user.setRoles(null);
		userService.updateUser(user);
		ArrayList<UserTracking> listeOfTrackings= userTrackingService.findByUser(user);
		listeOfTrackings.forEach((tracking)->{userTrackingService.deleteUserTracking(tracking);});

		userService.deleteUser(user); 
	    logger_.log(Constants.NORMAL_LOG_DIR, "Delete the user: " + user.getUserSurName(), httpServletRequest);		
	    return "OK";
	}

	

	
}
