package com.internship.hospital.form.formvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internship.hospital.form.DepartmentForm1;



@Component
public class DepartmentFormValidator1 implements Validator{

	public boolean supports(Class clazz) {
		return DepartmentForm1.class.isAssignableFrom(clazz);
	
	}

	@Override 
	public void validate( Object obj, Errors e) {
		DepartmentForm1 departmentForm = (DepartmentForm1)obj;
		if (departmentForm.equals(null)) {
			e.rejectValue("empty", "form.empty.exception");
	    }

	}
	
}
