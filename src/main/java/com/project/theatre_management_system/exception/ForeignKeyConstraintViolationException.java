package com.project.theatre_management_system.exception;

public class ForeignKeyConstraintViolationException extends RuntimeException{
 
	 private String msg="Cannot delete the screen  is referenced by another entity";
	
	   public void ForeignKeyConstraintViolationException(String message) {
//	        super(message);
	       
	        
}

	public String getMsg() {
		return msg;
	}

}