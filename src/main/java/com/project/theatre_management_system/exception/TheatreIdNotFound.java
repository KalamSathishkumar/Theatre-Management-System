package com.project.theatre_management_system.exception;

public class TheatreIdNotFound extends RuntimeException{

	private String message="Theatre id is not found the DB";

	public String getMessage() {
		return message;
	}
}