package com.internship.hospital.controller.hospital;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ManageHospitalsController {

	@RequestMapping(value ="/hospital", method = RequestMethod.GET)
	public String hospitals(){
		System.out.println("GET-LIST");
		return "hospital_sys/home";
		   
	}
	
	@RequestMapping(value ="/loginpage", method = RequestMethod.GET)
	public String welcome(){
		System.out.println("GET-LIST");
		return "hospital_sys/landingpage";
		   
	}
}
