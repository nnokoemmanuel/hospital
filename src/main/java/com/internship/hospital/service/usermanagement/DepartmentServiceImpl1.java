package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import com.internship.hospital.entity.departments.Department1;
import com.internship.hospital.entity.departments.DeptStatus;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.DepartmentForm1;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.repository.departments.DepartmentRepository1;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;
import com.internship.hospital.util.Tracker;

@Service("departmentService1")
public class DepartmentServiceImpl1 implements DepartmentService1 {


	@Autowired
	  private DepartmentRepository1 departmentRepository;
	
	@Autowired
	  private DeptStatusService departmentStatusService;
	
	@Autowired
	 private DepartmentService1 departmentService;
	
	@Autowired 
	private Logger_ logger_; 
	

	@Autowired
	private Tracker tracker;
	
	
	@Override
	public List<Department1> findAll(){
		return departmentRepository.findAll();
	}
	
	@Override
	public Department1 findById(int id){
		return departmentRepository.findById( id);
	}
	
	@Override
	public Department1 findByDeptName(String deptName){
		return departmentRepository.findByDeptName( deptName);
	}


	@Override
	public void deleteDepartment(Department1 department) {
		// TODO Auto-generated method stub
		departmentRepository.delete(department);
	}
	
	/**
	 * convert a form to bean
	 * @return
	 */
	@Override
	public Department1 persistDepartmentBean(DepartmentForm1 departmentForm,HttpServletRequest httpServletRequest) throws ParseException{

		Department1 department;	
		if(departmentForm.getId() ==0  ){
		    //case department does not exists yet
			//we create department
			DeptStatus deptStatus = departmentStatusService.findByDeptStatusName("ACTIVE");
			department = new Department1(departmentForm.getDeptName(),  deptStatus) ;
			createDepartment(department);
			tracker.track(department, "REGISTERED THE DEPARTMENT" , httpServletRequest);
			logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the department Registration: "+department);	

			return department;
			
		}else{
			Department1 departmentToEdit = departmentService.findById(departmentForm.getId());
			departmentToEdit.setDeptName(departmentForm.getDeptName());
            updateDepartment(departmentToEdit);
			tracker.track(departmentToEdit, "EDITED THE DEPARTMENT " , httpServletRequest);
    		logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the department Edition: "+departmentToEdit);
			return departmentToEdit;
		}
	}
	
	@Override
	public void createDepartment(Department1 department) {
		departmentRepository.save(department);
		
	}
	
	@Override
	public void updateDepartment(Department1 department) {
		departmentRepository.saveAndFlush(department);

	}
}
