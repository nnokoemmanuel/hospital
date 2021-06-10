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

import com.internship.hospital.entity.departments.Cashier;
import com.internship.hospital.entity.departments.Department1;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.form.CashierForm;
import com.internship.hospital.form.DepartmentForm1;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.formvalidator.CashierFormValidator;
import com.internship.hospital.form.formvalidator.DepartmentFormValidator1;
import com.internship.hospital.form.formvalidator.UserLoginValidator;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.service.usermanagement.CashierService;
import com.internship.hospital.service.usermanagement.DepartmentService1;
import com.internship.hospital.service.usermanagement.RoleService;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;

@Controller
public class CashierController {

	@Autowired
	private Logger_ logger_;
	@Autowired
	protected CashierFormValidator cashierFormValidator;

	@Autowired
	protected UserService userService;

	@Autowired
	protected RoleService roleService;

	@Autowired
	protected UserTrackingService userTrackingService;
	
	@Autowired
	protected CashierService cashierService;

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
	    binder.setValidator(cashierFormValidator);
	}

	@RequestMapping(value = "/cashier/create", method = RequestMethod.GET)
	public String createGet(Model model) {
		return "hospital_sys/cashier_create"; // form to create user
	}

	@RequestMapping(value = "/cashier/list", method = RequestMethod.GET)
	public String listCashier(Model model) {
		List<Cashier> allCashier = cashierService.findAll();
		model.addAttribute("cashiers", allCashier);
		return "hospital_sys/cashier_list"; // form to create user
	}

	
	 @ResponseBody 
	 @RequestMapping(value = "/cashier/createpost", method = RequestMethod.POST)
	 @Transactional 
	 public String createCashier(@ModelAttribute("cashierForm") @Validated CashierForm cashierForm, BindingResult result, HttpServletRequest httpServletRequest)throws ParseException { 
		 Cashier cashier;
	 
		 System.out.println("CashierForm "+ cashierForm.getUserName());
		 if(result.hasErrors()){ if(result.getFieldError("vide")!= null){
			 logger_.log(Constants.NORMAL_LOG_DIR,"Cashier form empty "+result.getFieldError("vide").getCode(),httpServletRequest); 
			 return result.getFieldError("vide").getCode(); } 
		 } 
		 if(cashierForm.getId() != -1 ){ 
			 cashier = cashierService.persistCashierBean(cashierForm, httpServletRequest);
		 }else{ 
			 cashier = cashierService.persistCashierBean(cashierForm,httpServletRequest);
		 } 
		 return "OK-"+String.valueOf(cashier.getId());
	 
	 }

	 @RequestMapping(value = "/cashier/edit", method = RequestMethod.GET) 
	 public String editGet(Model model,@RequestParam("id") int id) { 
     Cashier cashier =  cashierService.findById(id); 
	 model.addAttribute("cashier", cashier);
	  return "hospital_sys/cashiers/cashier_edit"; 
	  }
	 
	 @RequestMapping(value = "/cashier/detail/{id}", method = RequestMethod.GET) 
	 public String showGet(Model model,@PathVariable int id){
	  Cashier cashier = cashierService.findById(id);
	  model.addAttribute("cashier", cashier); 
	  return "hospital_sys/cashiers/cashier_detail"; 
	 }
	  
 
	 @ResponseBody
     @RequestMapping(value = "/cashier/delete/{id}") 
	 public String deleteCashier(@PathVariable int id, HttpServletRequest httpServletRequest){
	   Cashier cashier = cashierService.findById(id);
	   //ArrayList<UserTracking> listeOfTrackings=userTrackingService.findByUser(user);
	   //listeOfTrackings.forEach((tracking)->{userTrackingService.deleteUserTracking(tracking);});
	   if(cashier.getPaymentInfos().size() > 0)
		   return "KO";
	   cashierService.deleteCashier(cashier);
	   logger_.log(Constants.NORMAL_LOG_DIR,"Delete the cashier: " + cashier.getId(), httpServletRequest); 
	   return "OK"; 
	  }


}
