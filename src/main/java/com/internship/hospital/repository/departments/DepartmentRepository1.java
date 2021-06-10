package com.internship.hospital.repository.departments;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.internship.hospital.entity.departments.Department1;


@Repository("departmentRepository1")
public interface DepartmentRepository1 extends JpaRepository<Department1, String>{

	public Department1 findById(int id);
	
	public Department1 findByDeptName(String deptName);
	public List<Department1> findAll();
}
