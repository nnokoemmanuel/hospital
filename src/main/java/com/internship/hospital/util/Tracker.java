package com.internship.hospital.util;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.hospital.entity.users.User;
import com.internship.hospital.entity.users.UserTracking;
import com.internship.hospital.service.usermanagement.UserService;
import com.internship.hospital.service.usermanagement.UserTrackingService;



@Service("tracker")
public class Tracker {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserTrackingService userTrackingService;
	
	
	
	public void track(Object source, String operation, HttpServletRequest httpServletRequest){
	      if(source instanceof User){	    
	    	  trackUser( source ,  operation,  httpServletRequest );	        
	      }
	     
	}
	
	
	private void trackUser(Object source , String operation,  HttpServletRequest httpServletRequest ){
		
	  UserTracking tracking=new UserTracking();
  	  User name=(User)source;
  	  tracking.setOperation(operation);	    	  
  	  tracking.setUser(name);
  	  tracking.setOperationDate(new Date());
  	  userTrackingService.save(tracking);		
	}
	
}







	
	





