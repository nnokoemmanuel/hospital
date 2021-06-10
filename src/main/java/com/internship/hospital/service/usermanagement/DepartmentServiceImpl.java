package com.internship.hospital.service.usermanagement;

import java.text.ParseException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.internship.hospital.entity.departments.Department;
import com.internship.hospital.entity.users.Role;
import com.internship.hospital.entity.users.User;
import com.internship.hospital.form.DepartmentForm;
import com.internship.hospital.form.UserForm;
import com.internship.hospital.repository.departments.DepartmentRepository;
import com.internship.hospital.repository.users.UserRepository;
import com.internship.hospital.util.Constants;
import com.internship.hospital.util.Logger_;
import com.internship.hospital.util.Tracker;
import javax.servlet.http.HttpServletRequest;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService{

	@Autowired
	 private DepartmentRepository departmentRepository;
	
	@Autowired
	 private DepartmentService departmentService;
	

	
	
	@Autowired 
	private Logger_ logger_;
	

	@Autowired
	private Tracker tracker;
	
	@Override
	public Department findById(int id) {
		return departmentRepository.findById(id);
	}
	
	@Override
	public Department findByDepartmentName(String departmentName) {
		return departmentRepository.findByDepartmentName(departmentName);
	}
	
	@Override
	public Department findByDepartmentType(String departmentType) {
		return departmentRepository.findByDepartmentType(departmentType);
	}
	
	@Override
	public Department findByDepartmentDescription(String departmentDescription) {
		return departmentRepository.findByDepartmentDescription(departmentDescription);
	}
	
	public List<Department> findAll() {
		// TODO Auto-generated method stub
		return departmentRepository.findAll();
	}

	
	
	@Override
	public void deleteDepartment(Department department) {
		departmentRepository.delete(department);
	}
	
	/**
	 * convert a form to bean
	 * @return
	 */
	@Override
	public Department persistDepartmentBean(DepartmentForm departmentForm,HttpServletRequest httpServletRequest) throws ParseException{
		
		//User user = null;	
		Department department;	
		System.out.println("persistDepartmentBean");
		if(departmentForm.getId() ==0  ){
			System.out.println("0");
		    //case user does not exists yet
			//we create user
//userForm.getUserRole()
			department = new Department(departmentForm.getDepartmentName(), departmentForm.getDepartmentType(),departmentForm.getDepartmentDescription());
			System.out.println("createDepartment"+department);
			departmentService.createDepartment(department);
				/*String[] selectedRoles = userForm.getUserRole().split(",");
				Set<Role> rolesToPersist = new HashSet();
				for(String userRole : selectedRoles){
					Role role = roleService.findById(Integer.parseInt(userRole));
					if(role != null){
						rolesToPersist.add(role);
					}
					
				}
				user.setRoles(rolesToPersist);*/
			   System.out.println("updateDepartment"+department);
			    departmentService.updateDepartment(department);
				tracker.track(department, "REGISTERED THE DEPARTMENT" , httpServletRequest);
				logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the creation of department: "+department);	
				
				

			
			return department;
			
		}else{
			System.out.println("updateDepartment");
			Department departmentToEdit = departmentService.findById(departmentForm.getId());
			departmentToEdit.getDepartmentName();
			departmentToEdit.getDepartmentType();
			departmentToEdit.getDepartmentDescription();

			//departmentService.updateDepartment(departmentToEdit);
		    
		    /*String[] selectedRoles = userForm.getUserRole().split(",");
			Set<Role> rolesToPersist = new HashSet();
			for(String userRole : selectedRoles){
				Role role = roleService.findById(Integer.parseInt(userRole));
				if(role != null){
					rolesToPersist.add(role);
				}
				
			}
			userToEdit.setRoles(rolesToPersist);*/
			departmentToEdit.setDepartmentName(departmentForm.getDepartmentName());
			departmentToEdit.setDepartmentType(departmentForm.getDepartmentType());
			departmentToEdit.setDepartmentDescription(departmentForm.getDepartmentDescription());
			System.out.println("set="+departmentToEdit);
			departmentService.updateDepartment(departmentToEdit);
			tracker.track(departmentToEdit, "REGISTERED THE DEPARTMENT " , httpServletRequest);
    		logger_.log(Constants.NORMAL_LOG_DIR, "Initiates the creation of department: "+departmentToEdit);
			return departmentToEdit;
		}
	}
	
	@Override
	public void createDepartment(Department department) {
		departmentRepository.save(department);
		
	}
	
	@Override
	public void updateDepartment(Department department) {
		departmentRepository.saveAndFlush(department);

	}
	



}

	

