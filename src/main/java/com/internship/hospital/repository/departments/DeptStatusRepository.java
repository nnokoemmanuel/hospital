package com.internship.hospital.repository.departments;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.internship.hospital.entity.departments.DeptStatus;

@Repository("deptStatusRepository")
public interface DeptStatusRepository extends JpaRepository<DeptStatus, String>{

	public DeptStatus findById(int id);
	
	public DeptStatus findByDeptStatusName(String deptStatusName);
	
	public List<DeptStatus> findAll();
	
}
