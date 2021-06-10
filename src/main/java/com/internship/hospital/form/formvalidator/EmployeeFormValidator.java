package com.internship.hospital.form.formvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internship.hospital.form.EmployeeForm;



@Component
public class EmployeeFormValidator implements Validator{

	public boolean supports(Class clazz) {
		return EmployeeForm.class.isAssignableFrom(clazz);
	
	}

	@Override 
	public void validate( Object obj, Errors e) {
		EmployeeForm employeeForm = (EmployeeForm)obj;
		if (employeeForm.equals(null)) {
			e.rejectValue("empty", "form.empty.exception");
	    }

	}
	
}
