package com.project.theatre_management_system.exception;

public class EmployeeIdNotFound extends RuntimeException{

	private String message="Employee id is not found the DB";

	public String getMessage() {
		return message;
	}

}
