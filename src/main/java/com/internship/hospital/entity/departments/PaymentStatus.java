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
@Table(name="paymentStatus")
public class PaymentStatus {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private int id;
	private String paymentStatusName;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "paymentStatus")
	private Set<PaymentInfo> paymentInfos;

	public PaymentStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaymentStatus(String paymentStatusName) {
		super();
		this.paymentStatusName = paymentStatusName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPaymentStatusName() {
		return paymentStatusName;
	}

	public void setPaymentStatusName(String paymentStatusName) {
		this.paymentStatusName = paymentStatusName;
	}

	public Set<PaymentInfo> getPaymentInfos() {
		return paymentInfos;
	}

	public void setPaymentInfos(Set<PaymentInfo> paymentInfos) {
		this.paymentInfos = paymentInfos;
	}

	
}
