package com.internship.hospital.form.formvalidator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.internship.hospital.form.CashierForm;



@Component
public class CashierFormValidator implements Validator{

	public boolean supports(Class clazz) {
		return CashierForm.class.isAssignableFrom(clazz);
	
	}

	@Override 
	public void validate( Object obj, Errors e) {
		CashierForm cashierForm = (CashierForm)obj;
		if (cashierForm.equals(null)) {
			e.rejectValue("empty", "form.empty.exception");
	    }

	}
	
}
