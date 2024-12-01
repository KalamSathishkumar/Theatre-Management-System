package com.project.theatre_management_system.dto;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Payment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int paymentId;
	private String paymentType;
	private String paymentTransactionId;
	private Date paymentDateAndTime;
	private String paymentStatus;
	private String paymentCouponCode;
	public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public String getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	public String getPaymentTransactionId() {
		return paymentTransactionId;
	}
	public void setPaymentTransactionId(String paymentTransactionId) {
		this.paymentTransactionId = paymentTransactionId;
	}
	public Date getPaymentDateAndTime() {
		return paymentDateAndTime;
	}
	public void setPaymentDateAndTime(Date paymentDateAndTime) {
		this.paymentDateAndTime = paymentDateAndTime;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getPaymentCouponCode() {
		return paymentCouponCode;
	}
	public void setPaymentCouponCode(String paymentCouponCode) {
		this.paymentCouponCode = paymentCouponCode;
	}
	
	
	

}
