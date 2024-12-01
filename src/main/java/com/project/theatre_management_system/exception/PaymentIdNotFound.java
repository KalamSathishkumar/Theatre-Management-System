package com.project.theatre_management_system.exception;

public class PaymentIdNotFound extends RuntimeException{

	private String message="Payment id is not found the DB";

	public String getMessage() {
		return message;
	}
}
