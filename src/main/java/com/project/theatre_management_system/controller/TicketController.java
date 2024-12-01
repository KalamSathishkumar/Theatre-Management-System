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
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.service.TicketService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TicketController {
	
	@Autowired
	TicketService ticketService;
	@Operation(summary="Save Ticket",description="API is used to Save Ticket")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Ticket not found in the DB")})
	@PostMapping("/saveTicket")
	public ResponseStructure<Ticket> saveTicket(@RequestBody Ticket ticket) {
	return ticketService.saveTicket(ticket);
	}
	
	   @Operation(summary = "update Ticket", description = "API is used to update the Ticket")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ticket sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Ticket not found in the DB")})
	@PutMapping("/updateTicketById")
	public ResponseStructure<Ticket> updateTicketById(@RequestParam int oldTicketId,@RequestBody Ticket newTicket) {
          return ticketService.updateTicketById(oldTicketId, newTicket);
	}
	
	   @Operation(summary = "Fetch Ticket", description = "API is used to fetch the Ticket")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Ticket sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Ticket not found in the DB")})
	@GetMapping("/fetchByTicketId")
	public ResponseStructure<Ticket> fetchByTicketId(@RequestParam int ticketId) {
	return	ticketService.fetchByTicketId(ticketId);
	}
	
	   @Operation(summary = "Fetch All the Tickets", description = "API is used to fetch all the Tickets")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Tickets sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Ticket not found in the DB")})
	@GetMapping("/fetchAllTicket")
	public ResponseStructureList<Ticket> fetchAllTicket(){
		return ticketService.fetchAllTicket();
	}
	
	   @Operation(summary = "delete Ticket", description = "API is used to delete the Ticket")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Ticket sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Ticket not found in the DB")}) 
	@DeleteMapping("/deleteTicketById")
	public ResponseStructure<Ticket> deleteTicketById(@RequestParam int ticketId) {
		return ticketService.deleteTicketById(ticketId);
	}
	   @Operation(summary = "addExistingPaymentToExistingTicket", description = "API is used to add Existing Payment To Existing Ticket")
			@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Payment To Existing Ticket in DB"),
					@ApiResponse(responseCode = "404", description = "Ticket not found in the DB"),
					@ApiResponse(responseCode = "404", description = "Payment not found in the DB")})
	@PutMapping("/addExistingPaymentToExistingTicket")
	public ResponseStructure<Ticket> addExistingPaymentToExistingTicket(@RequestParam int paymentId,@RequestParam int TicketId) {	      
		return ticketService.addExistingPaymentToExistingTicket(paymentId, TicketId);
	     
	}
	   @Operation(summary = "addNewPaymentToExistingTicket", description = "API is used to added New Payment To Existing Ticket")
			@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Payment To Existing Ticket in DB"),
					@ApiResponse(responseCode = "404", description = "Ticket not found in the DB")})
	@PutMapping("/addNewPaymentToExistingTicket")
	public ResponseStructure<Ticket> addNewPaymentToExistingTicket(@RequestParam int ticketId,@RequestBody Payment newPayment) {
         return ticketService.addNewPaymentToExistingTicket(ticketId, newPayment);
	}
}
