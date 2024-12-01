package com.project.theatre_management_system.exception;

public class AudienceIdNotFound extends RuntimeException {

	private String message="Audience id is not found the DB";

	public String getMessage() {
		return message;
	}
	
}
