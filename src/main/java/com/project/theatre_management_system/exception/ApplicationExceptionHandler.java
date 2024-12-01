 package com.project.theatre_management_system.exception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project.theatre_management_system.util.ResponseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler {
	
	@Autowired
	ResponseStructure<String> responseStructure;
	
	@ExceptionHandler(OwnerIdNotFound.class)
	public  ResponseStructure<String> ownerIdNotFound(OwnerIdNotFound ownerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("owner id not found in the DB");
		responseStructure.setData(ownerIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(AudienceIdNotFound.class)
	public  ResponseStructure<String> audienceIdNotFound(AudienceIdNotFound audienceIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Audience id not found in the DB");
		responseStructure.setData(audienceIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(AddressIdNotFound.class)
	public  ResponseStructure<String> addressIdNotFound(AddressIdNotFound addressIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Address id not found in the DB");
		responseStructure.setData(addressIdNotFound.getMessage());
		return responseStructure;	
	}
	@ExceptionHandler(BranchIdNotFound.class)
	public  ResponseStructure<String> branchIdNotFound(BranchIdNotFound branchIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("branch id not found in the DB");
		responseStructure.setData(branchIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(EmployeeIdNotFound.class)
	public  ResponseStructure<String> employeeIdNotFound(EmployeeIdNotFound employeeIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("employee id not found in the DB");
		responseStructure.setData(employeeIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(FoodIdNotFound.class)
	public  ResponseStructure<String> foodIdNotFound(FoodIdNotFound foodIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("food id not found in the DB");
		responseStructure.setData(foodIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(ManagerIdNotFound.class)
	public  ResponseStructure<String> managerIdNotFound(ManagerIdNotFound managerIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("manager id not found in the DB");
		responseStructure.setData(managerIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(MovieIdNotFound.class)
	public  ResponseStructure<String> movieIdNotFound(MovieIdNotFound movieIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("movie id not found in the DB");
		responseStructure.setData(movieIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(PaymentIdNotFound.class)
	public  ResponseStructure<String> paymentIdNotFound(PaymentIdNotFound paymentIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("payment id not found in the DB");
		responseStructure.setData(paymentIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(ScreenIdNotFound.class)
	public  ResponseStructure<String> screenIdNotFound(ScreenIdNotFound screenIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("screen id not found in the DB");
		responseStructure.setData(screenIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(SeatIdNotFound.class)
	public  ResponseStructure<String> seatIdNotFound(SeatIdNotFound seatIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("seat id not found in the DB");
		responseStructure.setData(seatIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(TheatreIdNotFound.class)
	public  ResponseStructure<String> theatreIdNotFound(TheatreIdNotFound theatreIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("theatre id not found in the DB");
		responseStructure.setData(theatreIdNotFound.getMessage());
		return responseStructure;	
	}
	
	@ExceptionHandler(TicketIdNotFound.class)
	public  ResponseStructure<String> ticketIdNotFound(TicketIdNotFound ticketIdNotFound) {
		responseStructure.setStatusCode(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("Ticket id not found in the DB");
		responseStructure.setData(ticketIdNotFound.getMessage());
		return responseStructure;	
	}

	
//    @ExceptionHandler(ForeignKeyConstraintViolationException.class)
//    public ResponseStructure<String> handleForeignKeyConstraintViolation(ForeignKeyConstraintViolationException ex) {
//        return new ResponseStructure()<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
//    }
}
