package com.internship.hospital.form;

public class PatientForm {

	private int id;
	private String patientName;
	private String patientTel;
	private String patientAddress;
	private String patientContact;
	private String patientNextOfKin;
	
	
	public PatientForm() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public PatientForm(String patientName, String patientTel, String patientAddress, String patientContact,
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
	
    
	

	
}
