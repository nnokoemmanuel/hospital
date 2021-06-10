package com.internship.hospital.form;

public class RoleForm {

	private int id;
	private String roleName;
	private String roleDesc;


	private RoleForm() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RoleForm(String roleName, String roleDesc) {
		super();
		this.roleName = roleName;
		this.roleDesc = roleDesc;
	}

    
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getRoleName() {
		return roleName;
	}


	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}


	public String getRoleDesc() {
		return roleDesc;
	}


	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}

	
}
