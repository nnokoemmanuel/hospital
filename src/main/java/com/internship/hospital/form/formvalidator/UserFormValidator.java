package com.internship.hospital.form.formvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import com.internship.hospital.form.UserForm;


@Component
public class UserFormValidator implements Validator{

	public boolean supports(Class clazz) {
		return UserForm.class.isAssignableFrom(clazz);
	
	}

	@Override 
	public void validate( Object obj, Errors e) {
		UserForm userForm = (UserForm)obj;
		if (userForm.equals(null)) {
			e.rejectValue("empty", "form.empty.exception");
	    }

	}
	
}
