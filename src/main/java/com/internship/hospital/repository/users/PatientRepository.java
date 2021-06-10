package com.internship.hospital.repository.users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.internship.hospital.entity.departments.Patient;
import com.internship.hospital.entity.users.Role;


@Repository("patientRepository")
public interface PatientRepository extends JpaRepository<Patient, String>{

	List<Patient> findAll();
	public Patient findById(int id);
}
