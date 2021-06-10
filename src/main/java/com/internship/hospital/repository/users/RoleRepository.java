package com.internship.hospital.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.hospital.entity.users.Role;


@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, String>{

	List<Role> findAll();
	public Role findById(int id);
	
	public Role findByRoleName(String roleName);

	public Role findByRoleDesc(String roleDesc);
}
