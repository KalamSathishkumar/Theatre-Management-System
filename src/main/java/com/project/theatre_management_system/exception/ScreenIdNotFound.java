package com.project.theatre_management_system.exception;

public class ScreenIdNotFound extends RuntimeException{

	private String message="Screen id is not found the DB";

	public String getMessage() {
		return message;
	}
}
