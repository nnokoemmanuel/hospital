package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.internship.hospital.entity.users.Role;
import com.internship.hospital.form.RoleForm;

public interface RoleService {

public Role findById(int id);
    public void createRole(Role role); 
    public void updateRole(Role role); 
	public Role findByRoleName(String name);
	public Role findByRoleDesc(String desc);	
	public List<Role> findAll();
	public void deleteRole(Role role);
	public Role persistRoleBean(RoleForm roleForm,HttpServletRequest httpServletRequest) throws ParseException;
}
