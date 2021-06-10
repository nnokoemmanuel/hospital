package com.internship.hospital.form.formvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internship.hospital.form.CashierForm;
import com.internship.hospital.form.PatientForm;
import com.internship.hospital.form.RoleForm;



@Component
public class PatientFormValidator implements Validator{

	public boolean supports(Class clazz) {
		return PatientForm.class.isAssignableFrom(clazz);
	
	}

	@Override 
	public void validate( Object obj, Errors e) {
		PatientForm patientForm = (PatientForm)obj;
		if (patientForm.equals(null)) {
			e.rejectValue("empty", "form.empty.exception");
	    }

	}
	
}
