package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;
import com.internship.hospital.util.Tracker;
import javax.servlet.http.HttpServletRequest;

@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	 private UserRepository userRepository;
	
	@Autowired
	 private UserService userService;
	
	@Autowired
	 private RoleService roleService;
	
	
	
	@Autowired 
	private Logger_ logger_;
	

	@Autowired
	private Tracker tracker;
	
	@Override
	public User findById(int id) {
		return userRepository.findById(id);
	}
	
	@Override
	public User findByUserName(String name) {
		return userRepository.findByUserName(name);
	}
	
	@Override
	public User findByUserEmail(String email) {
		return userRepository.findByUserEmail(email);
	}
	@Override
	public User findByUserDob(String dob) {
		return userRepository.findByUserDob(dob);
	}
	@Override
	public User findByUserAddress(String address) {
		return userRepository.findByUserAddress(address);
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public User findByUserGivenName(String givenName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserGivenName(givenName);
	}

	@Override
	public User findByUserSurName(String surName) {
		// TODO Auto-generated method stub
		return userRepository.findByUserSurName(surName);
	}
	
	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}
	
	/**
	 * convert a form to bean
	 * @return
	 */
	@Override
	public User persistUserBean(UserForm userForm,HttpServletRequest httpServletRequest) throws ParseException{
		
		//User user = null;	
		User user;	
		if(userForm.getId() ==0  ){
		    //case user does not exists yet
			//we create user
//userForm.getUserRole()
				user = new User(userForm.getUserName(), userForm.getUserEmail(),userForm.getUserDob(), userForm.getUserAddress(), userForm.getUserPassword(), userForm.getUserSurName(),
						userForm.getUserGivenName());
				userService.createUser(user);
				String[] selectedRoles = userForm.getUserRole().split(",");
				Set<Role> rolesToPersist = new HashSet();
				for(String userRole : selectedRoles){
					Role role = roleService.findById(Integer.parseInt(userRole));
					if(role != null){
						rolesToPersist.add(role);
					}
					
				}
				user.setRoles(rolesToPersist);
				userService.updateUser(user);
				tracker.track(user, "REGISTERED THE USER" , httpServletRequest);
				logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the user Registration: "+user);	
				
				

			
			return user;
			
		}else{
			User userToEdit = userService.findById(userForm.getId());
			userToEdit.setUserAddress(userForm.getUserAddress());
			userToEdit.setUserDob(userForm.getUserDob());
			userToEdit.setUserEmail(userForm.getUserEmail());
			userToEdit.setUserGivenName(userForm.getUserGivenName());
			userToEdit.setUserName(userForm.getUserName());
			userToEdit.setUserPassword(userForm.getUserPassword());
			userToEdit.setUserSurName(userForm.getUserSurName());

		    userService.updateUser(userToEdit);
		    
		    String[] selectedRoles = userForm.getUserRole().split(",");
			Set<Role> rolesToPersist = new HashSet();
			for(String userRole : selectedRoles){
				Role role = roleService.findById(Integer.parseInt(userRole));
				if(role != null){
					rolesToPersist.add(role);
				}
				
			}
			userToEdit.setRoles(rolesToPersist);
			userService.updateUser(userToEdit);
			tracker.track(userToEdit, "EDITED THE USER " , httpServletRequest);
    		logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the user Edition: "+userToEdit);
			return userToEdit;
		}
	}
	
	@Override
	public void createUser(User user) {
		userRepository.save(user);
		
	}
	
	@Override
	public void updateUser(User user) {
		userRepository.saveAndFlush(user);

	}
	



}

	

