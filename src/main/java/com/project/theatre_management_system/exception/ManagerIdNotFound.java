package com.project.theatre_management_system.exception;

public class ManagerIdNotFound extends RuntimeException{

	private String message="Manager id is not found the DB";

	public String getMessage() {
		return message;
	}
}
