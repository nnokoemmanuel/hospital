package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.hospital.entity.departments.Patient;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.PatientForm;
import com.internship.hospital.form.RoleForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.repository.users.PatientRepository;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;
import com.internship.hospital.util.Tracker;

@Service("patientService")
public class PatientServiceImpl implements PatientService {

	@Autowired
	  private PatientRepository patientRepository;
	
	@Autowired
	  private PatientService patientService;
	
	@Autowired 
	private Logger_ logger_;
	

	@Autowired
	private Tracker tracker;
	
	
	@Override
	public List<Patient> findAll(){
		return patientRepository.findAll();
	}
	
	@Override
	public Patient findById(int id){
		return patientRepository.findById( id);
	}
	
	@Override
	public void deletePatient(Patient patient) {
		patientRepository.delete(patient);
	}
	
	/**
	 * convert a form to bean
	 * @return
	 */
	@Override
	public Patient persistPatientBean(PatientForm patientForm,HttpServletRequest httpServletRequest) throws ParseException{
		

		Patient patient;	
		if(patientForm.getId() ==0  ){
		    //case Patient does not exists yet
			//we create Patient

			    patient = new Patient(patientForm.getPatientName(), patientForm.getPatientTel(), patientForm.getPatientAddress(), patientForm.getPatientContact(),
			    		patientForm.getPatientNextOfKin()) ;
			    patientService.createPatient(patient);
				tracker.track(patient, "REGISTERED THE PATIENT" , httpServletRequest);
				logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the Patient Registration: "+patient);	
			    return patient;
			
		}else{
			Patient patientToEdit = patientService.findById(patientForm.getId());
			patientToEdit.setPatientAddress(patientForm.getPatientAddress());
			patientToEdit.setPatientContact(patientForm.getPatientContact());
			patientToEdit.setPatientName(patientForm.getPatientName());
			patientToEdit.setPatientNextOfKin(patientForm.getPatientNextOfKin());
			patientToEdit.setPatientTel(patientForm.getPatientTel());
			patientService.updatePatient(patientToEdit);
		 
			tracker.track(patientToEdit, "EDITED THE PATIENT " , httpServletRequest);
    		logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the Patient Edition: "+patientToEdit);
			return patientToEdit;
		}
	}
	
	@Override
	public void createPatient(Patient patient) {
		patientRepository.save(patient);
		
	}
	
	@Override
	public void updatePatient(Patient patient) {
		patientRepository.saveAndFlush(patient);

	}
	

	
	

	
}
