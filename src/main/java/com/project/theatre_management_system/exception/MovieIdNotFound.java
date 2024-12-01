package com.project.theatre_management_system.exception;

public class MovieIdNotFound extends RuntimeException{

	private String message="Movie id is not found the DB";

	public String getMessage() {
		return message;
	}
}
