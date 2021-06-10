package com.internship.hospital.service.usermanagement;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.internship.hospital.entity.departments.DeptStatus;
import com.internship.hospital.repository.departments.DeptStatusRepository;


@Service("deptStatusService")
public class DeptStatusServiceImpl implements DeptStatusService{

	@Autowired
	 private DeptStatusRepository deptStatusRespository;
	
	@Override
	public DeptStatus findById(int id) {
		// TODO Auto-generated method stub
		return deptStatusRespository.findById(id);
	}

	@Override
	public DeptStatus findByDeptStatusName(String deptStatusName) {
		// TODO Auto-generated method stub
		return deptStatusRespository.findByDeptStatusName( deptStatusName);
	}

	@Override
	public List<DeptStatus> findAll() {
		// TODO Auto-generated method stub
		return deptStatusRespository.findAll();
	}

	@Override
	public void deleteDeptStatus(DeptStatus deptStatus) {
		// TODO Auto-generated method stub
		deptStatusRespository.delete(deptStatus);
	}

	
}
