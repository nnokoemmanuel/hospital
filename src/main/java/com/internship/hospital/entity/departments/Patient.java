package com.internship.hospital.entity.departments;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="patients")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String patientName;
	private String patientTel;
	private String patientAddress;
	private String patientContact;
	private String patientNextOfKin;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "patient")
	private Set<PatientConsultation> patientConsultations;

	public Patient() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Patient(String patientName, String patientTel, String patientAddress, String patientContact,
			String patientNextOfKin) {
		super();
		this.patientName = patientName;
		this.patientTel = patientTel;
		this.patientAddress = patientAddress;
		this.patientContact = patientContact;
		this.patientNextOfKin = patientNextOfKin;
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getPatientTel() {
		return patientTel;
	}

	public void setPatientTel(String patientTel) {
		this.patientTel = patientTel;
	}

	public String getPatientAddress() {
		return patientAddress;
	}

	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}

	public String getPatientContact() {
		return patientContact;
	}

	public void setPatientContact(String patientContact) {
		this.patientContact = patientContact;
	}

	public String getPatientNextOfKin() {
		return patientNextOfKin;
	}

	public void setPatientNextOfKin(String patientNextOfKin) {
		this.patientNextOfKin = patientNextOfKin;
	}

	public Set<PatientConsultation> getPatientConsultations() {
		return patientConsultations;
	}

	public void setPatientConsultations(Set<PatientConsultation> patientConsultations) {
		this.patientConsultations = patientConsultations;
	}
	

	
}