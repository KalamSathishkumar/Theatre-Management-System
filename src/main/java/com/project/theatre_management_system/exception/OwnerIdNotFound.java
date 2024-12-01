package com.project.theatre_management_system.exception;

public class OwnerIdNotFound extends RuntimeException {
	
	private String message="owner id is not found the DB";

	public String getMessage() {
		return message;
	}
	
	

}
