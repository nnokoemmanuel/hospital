package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.RoleForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.repository.users.RoleRepository;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;
import com.internship.hospital.util.Tracker;

@Service("roleService")
public class RoleServiceImpl implements RoleService {

	@Autowired
	  private RoleRepository roleRepository;
	
	@Autowired
	  private RoleService roleService;
	
	@Autowired 
	private Logger_ logger_;
	

	@Autowired
	private Tracker tracker;
	
	
	@Override
	public List<Role> findAll(){
		return roleRepository.findAll();
	}
	
	@Override
	public Role findById(int id){
		return roleRepository.findById( id);
	}
	
	@Override
	public Role findByRoleName(String roleName){
		return roleRepository.findByRoleName( roleName);
	}
	
	@Override
	public Role findByRoleDesc(String roleDesc){
		return roleRepository.findByRoleDesc( roleDesc);
		
	}
	
	@Override
	public void deleteRole(Role role) {
		roleRepository.delete(role);
	}
	
	/**
	 * convert a form to bean
	 * @return
	 */
	@Override
	public Role persistRoleBean(RoleForm roleForm,HttpServletRequest httpServletRequest) throws ParseException{
		

		Role role;	
		if(roleForm.getId() ==0  ){
		    //case role does not exists yet
			//we create role

				role = new Role( roleForm.getRoleName(),  roleForm.getRoleDesc()) ;
				roleService.createRole(role);
				tracker.track(role, "REGISTERED THE ROLE" , httpServletRequest);
				logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the role Registration: "+role);	
			    return role;
			
		}else{
			Role roleToEdit = roleService.findById(roleForm.getId());
			roleToEdit.setRoleDesc(roleForm.getRoleDesc());
			roleToEdit.setRoleName(roleForm.getRoleName());
		    roleService.updateRole(roleToEdit);
		 
			tracker.track(roleToEdit, "EDITED THE ROLE " , httpServletRequest);
    		logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the role Edition: "+roleToEdit);
			return roleToEdit;
		}
	}
	
	@Override
	public void createRole(Role role) {
		roleRepository.save(role);
		
	}
	
	@Override
	public void updateRole(Role role) {
		roleRepository.saveAndFlush(role);

	}
	

	
	

	
}
