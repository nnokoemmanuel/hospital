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
@Table(name="paymentType")
class PaymentType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String paymentTypeName;

	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "paymentType")
	private Set<PaymentInfo> paymentInfos;


	public PaymentType() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PaymentType(String paymentTypeName) {
		super();
		this.paymentTypeName = paymentTypeName;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getPaymentTypeName() {
		return paymentTypeName;
	}


	public void setPaymentTypeName(String paymentTypeName) {
		this.paymentTypeName = paymentTypeName;
	}


	public Set<PaymentInfo> getPaymentInfos() {
		return paymentInfos;
	}


	public void setPaymentInfos(Set<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}
	
	
}
