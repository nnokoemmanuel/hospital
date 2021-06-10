package com.internship.hospital.form.formvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internship.hospital.form.UserLoginForm;

@Component
public class UserLoginValidator implements Validator {

	public boolean supports(Class clazz) {
		return UserLoginForm.class.isAssignableFrom(clazz);
	
	}

	@Override // when someone enters a field with less than 3  char will reject
	public void validate( Object obj, Errors e) {
		UserLoginForm userloginform = (UserLoginForm)obj;

		if (userloginform.equals(null)) {
			e.rejectValue("empty", "form.empty.exception");
	    }
		
		//make sure that the form has a username
		if (userloginform.getUserName().trim().length()==0) {
			e.rejectValue("username", "form.empty.username.exception");
	    }
		
		if (userloginform.getUserPassword().trim().length()==0) {
			e.rejectValue("userpassword", "form.empty.userpassword.exception");
	    }
		
	}
	
}
