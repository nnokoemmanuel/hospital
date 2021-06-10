package com.internship.hospital.entity.departments;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="patientConsulations")
public class PatientConsultation {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String patientConsultation;
	private String patientConsultationRemark;

	@ManyToOne
    @JoinColumn(name = "patient_id")
    private Patient patient;
	
	@ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public PatientConsultation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PatientConsultation(String patientConsultation, String patientConsultationRemark) {
		super();
		this.patientConsultation = patientConsultation;
		this.patientConsultationRemark = patientConsultationRemark;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientConsultation() {
		return patientConsultation;
	}

	public void setPatientConsultation(String patientConsultation) {
		this.patientConsultation = patientConsultation;
	}

	public String getPatientConsultationRemark() {
		return patientConsultationRemark;
	}

	public void setPatientConsultationRemark(String patientConsultationRemark) {
		this.patientConsultationRemark = patientConsultationRemark;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
}
