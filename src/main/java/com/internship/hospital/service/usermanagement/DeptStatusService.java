package com.internship.hospital.service.usermanagement;

import java.util.List;
import com.internship.hospital.entity.departments.DeptStatus;

public interface DeptStatusService {

public DeptStatus findById(int id);
	
	public DeptStatus findByDeptStatusName(String deptStatusName);
	
	public List<DeptStatus> findAll();
	
	public void deleteDeptStatus(DeptStatus deptStatus);

	
}
