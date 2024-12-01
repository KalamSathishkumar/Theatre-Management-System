package com.project.theatre_management_system.exception;

public class TicketIdNotFound extends RuntimeException{

	private String message="Ticket id is not found the DB";

	public String getMessage() {
		return message;
	}
}
