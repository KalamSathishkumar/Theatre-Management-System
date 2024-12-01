package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Payment;
import com.project.theatre_management_system.service.PaymentService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@Operation(summary="Save Payment",description="API is used to Save Payment")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Payment not found in the DB")})
	@PostMapping("/savePayment")
	public ResponseStructure<Payment> savePayment(@RequestBody Payment payment) {
	return paymentService.savePayment(payment);
	}
	
	   @Operation(summary = "update Payment", description = "API is used to update the Payment")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Payment sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Payment not found in the DB")})
	@PutMapping("/updatePaymentById")
	public ResponseStructure<Payment> updatePaymentById(@RequestParam int oldPaymentId,@RequestBody Payment newPayment) {
          return paymentService.updatePaymentById(oldPaymentId, newPayment);
	}
	
	   @Operation(summary = "Fetch Payment", description = "API is used to fetch the Payment")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Payment sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Payment not found in the DB")})
	@GetMapping("/fetchByPaymentId")
	public ResponseStructure<Payment> fetchByPaymentId(@RequestParam int paymentId) {
	return	paymentService.fetchByPaymentId(paymentId);
	}
	   @Operation(summary = "Fetch All the Payments", description = "API is used to fetch all the Payments")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Payments sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Payment not found in the DB")})
	@GetMapping("/fetchAllPayment")
	public ResponseStructureList<Payment> fetchAllPayment(){
		return paymentService.fetchAllPayment();
	}
	
	   @Operation(summary = "delete Payment", description = "API is used to delete the Payment")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Payment sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Payment not found in the DB")}) 
	@DeleteMapping("/deletePaymentById")
	public ResponseStructure<Payment> deletePaymentById(@RequestParam int paymentId) {
		return paymentService.deletePaymentById(paymentId);
	}

}
