package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.internship.hospital.entity.departments.Patient;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.form.PatientForm;
import com.internship.hospital.form.RoleForm;

public interface PatientService {

public Patient findById(int id);
    public void createPatient(Patient patient); 
    public void updatePatient(Patient patient); 	
	public List<Patient> findAll();
	public void deletePatient(Patient patient);
	public Patient persistPatientBean(PatientForm patientForm,HttpServletRequest httpServletRequest) throws ParseException;
}
