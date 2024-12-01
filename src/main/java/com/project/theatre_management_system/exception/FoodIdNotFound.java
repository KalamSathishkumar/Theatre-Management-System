package com.project.theatre_management_system.exception;

public class FoodIdNotFound extends RuntimeException{

	private String message="Food id is not found the DB";

	public String getMessage() {
		return message;
	}
	
}
