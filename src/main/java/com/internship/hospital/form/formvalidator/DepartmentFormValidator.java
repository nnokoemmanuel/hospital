package com.internship.hospital.form.formvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internship.hospital.form.DepartmentForm;
import com.internship.hospital.form.UserForm;



@Component
public class DepartmentFormValidator implements Validator{

	public boolean supports(Class clazz) {
		return DepartmentForm.class.isAssignableFrom(clazz);
	
	}

	@Override 
	public void validate( Object obj, Errors e) {
		DepartmentForm departmentForm = (DepartmentForm)obj;
		if (departmentForm.equals(null)) {
			e.rejectValue("empty", "form.empty.exception");
	    }

	}
	
}
