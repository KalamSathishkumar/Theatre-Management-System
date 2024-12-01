package com.project.theatre_management_system.exception;

public class AddressIdNotFound extends RuntimeException{

	private String message="Address id is not found the DB";

	public String getMessage() {
		return message;
	}
	
}
