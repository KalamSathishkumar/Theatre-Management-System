package com.project.theatre_management_system.exception;

public class SeatIdNotFound extends RuntimeException{

	private String message="Seat id is not found the DB";

	public String getMessage() {
		return message;
	}
	
}
