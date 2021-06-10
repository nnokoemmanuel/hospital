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
import com.internship.hospital.entity.departments.Patient;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.form.CashierForm;
import com.internship.hospital.form.DepartmentForm1;
import com.internship.hospital.form.PatientForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.form.formvalidator.CashierFormValidator;
import com.internship.hospital.form.formvalidator.DepartmentFormValidator1;
import com.internship.hospital.form.formvalidator.PatientFormValidator;
import com.internship.hospital.form.formvalidator.UserLoginValidator;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.service.usermanagement.CashierService;
import com.internship.hospital.service.usermanagement.DepartmentService1;
import com.internship.hospital.service.usermanagement.PatientService;
import com.internship.hospital.service.usermanagement.RoleService;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;

@Controller
public class patientController {

	@Autowired
	private Logger_ logger_;
	@Autowired
	protected PatientFormValidator patientFormValidator;

	@Autowired
	protected UserService userService;

	@Autowired
	protected RoleService roleService;

	@Autowired
	protected UserTrackingService userTrackingService;
	
	@Autowired
	protected CashierService cashierService;
	
	@Autowired
	protected PatientService patientService;

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
	   // binder.setValidator(patientFormValidator);
	}

	@RequestMapping(value = "/patient/list", method = RequestMethod.GET)
	public String listPatient(Model model) {
		System.out.println("GET PATIENT-LIST");
		List<Patient> allPatient = patientService.findAll();
		model.addAttribute("patient", allPatient);
		return "hospital_sys/patient/patient_list"; // form to create patient
	}
	
	
	@RequestMapping(value = "/patient/create", method = RequestMethod.GET)
	public String createGet(Model model) {
		return "hospital_sys/patient/patient_create"; // form to create patient
	}


	
	 @ResponseBody 
	 @RequestMapping(value = "/patient/createpost", method = RequestMethod.POST)
	 @Transactional 
	 public String createPatient(@ModelAttribute("patientForm") @Validated PatientForm patientForm, BindingResult result, HttpServletRequest httpServletRequest)throws ParseException { 
		 Patient patient;
	 
		 System.out.println("PatientForm "+ patientForm.getPatientName());
		 if(result.hasErrors()){ if(result.getFieldError("vide")!= null){
			 logger_.log(Constants.NORMAL_LOG_DIR,"Patient form empty "+result.getFieldError("vide").getCode(),httpServletRequest); 
			 return result.getFieldError("vide").getCode(); } 
		 } 
		 if(patientForm.getId() != -1 ){ 
			 patient = patientService.persistPatientBean(patientForm, httpServletRequest);
		 }else{ 
			 patient = patientService.persistPatientBean(patientForm,httpServletRequest);
		 } 
		 return "OK-"+String.valueOf(patient.getId());
	 
	 }

	 @RequestMapping(value = "/patient/edit", method = RequestMethod.GET) 
	 public String editGet(Model model,@RequestParam("id") int id) { 
		 Patient patient =  patientService.findById(id); 
	 model.addAttribute("patient", patient);
	  return "hospital_sys/patient/patient_edit"; 
	  }
	 
	
	 @RequestMapping(value = "/patient/detail", method = RequestMethod.GET)
	 public String showGet(Model model,@RequestParam("id") int id) {
		 System.out.println("GET PATIENT DETAIL");
		 Patient patient = patientService.findById(id);
	  model.addAttribute("patient", patient); 
	  return "hospital_sys/patient/patient_detail"; 
	 }
	  
 
	 @ResponseBody
     @RequestMapping(value = "/patient/delete/{id}") 
	 public String deletePatient(@PathVariable int id, HttpServletRequest httpServletRequest){
		 System.out.println("GET DELETE");                                                                                                                          
		 Patient patient = patientService.findById(id);
	   //ArrayList<UserTracking> listeOfTrackings=userTrackingService.findByUser(user);
	   //listeOfTrackings.forEach((tracking)->{userTrackingService.deleteUserTracking(tracking);});
	   if(patient.getPatientConsultations().size() > 0)
		   return "KO";
	   patientService.deletePatient(patient);
	   logger_.log(Constants.NORMAL_LOG_DIR,"Delete the Patient: " + patient.getId(), httpServletRequest); 
	   return "OK"; 
	  }


}
