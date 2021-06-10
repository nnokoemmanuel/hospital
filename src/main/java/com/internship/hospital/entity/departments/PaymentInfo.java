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
@Table(name="paymentInfo")
public class PaymentInfo {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String patientConsultation;
	private String patientConsultationRemark;

	@ManyToOne
    @JoinColumn(name = "cashier_id")
    private Cashier cashier;

	@ManyToOne
    @JoinColumn(name = "paymentType_id")
    private PaymentType paymentType;

	@ManyToOne
    @JoinColumn(name = "paymentStatus_id")
    private PaymentStatus paymentStatus;

	public PaymentInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentInfo(String patientConsultation, String patientConsultationRemark) {
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

	public Cashier getCashier() {
		return cashier;
	}

	public void setCashier(Cashier cashier) {
		this.cashier = cashier;
	}

	public PaymentType getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(PaymentType paymentType) {
		this.paymentType = paymentType;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
}
