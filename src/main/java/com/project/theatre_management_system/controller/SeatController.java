package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.dto.Ticket;
import com.project.theatre_management_system.service.SeatService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class SeatController {
	
	@Autowired
	SeatService seatService;
	
	@Operation(summary="Save Seat",description="API is used to Save Seat")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Seat not found in the DB")})
	@PostMapping("/saveSeat")
	public ResponseStructure<Seat> saveSeat(@RequestBody Seat seat) {
	return seatService.saveSeat(seat);
	}
	
	   @Operation(summary = "update Seat", description = "API is used to update the Seat")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Seat sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Seat not found in the DB")})
	@PutMapping("/updateSeatById")
	public ResponseStructure<Seat> updateSeatById(@RequestParam int oldSeatId,@RequestBody Seat newSeat) {
          return seatService.updateSeatById(oldSeatId, newSeat);
	}
	
	   @Operation(summary = "Fetch Seat", description = "API is used to fetch the Seat")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Seat sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Seat not found in the DB")})
	@GetMapping("/fetchBySeatId")
	public ResponseStructure<Seat> fetchBySeatId(@RequestParam int seatId) {
	return	seatService.fetchBySeatId(seatId);
	}
	
	   @Operation(summary = "Fetch All the Seats", description = "API is used to fetch all the Seats")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Seats sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Seat not found in the DB")})
	@GetMapping("/fetchAllSeat")
	public ResponseStructureList<Seat> fetchAllSeat(){
		return seatService.fetchAllSeat();
	}
	
	   @Operation(summary = "delete Seat", description = "API is used to delete the Seat")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Seat sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Seat not found in the DB")}) 
	@DeleteMapping("/deleteSeatById")
	public ResponseStructure<Seat> deleteSeatById(@RequestParam int seatId) {
		return seatService.deleteSeatById(seatId);
	}
	
	   @Operation(summary = "addExistingTicketToExistingSeat", description = "API is used to add Existing Ticket To Existing Seat")
			@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Ticket To Existing Seat in DB"),
					@ApiResponse(responseCode = "404", description = "Seat not found in the DB"),
					@ApiResponse(responseCode = "404", description = "Ticket not found in the DB")})
	@PutMapping("/addExistingTicketToExistingSeat")
	public ResponseStructure<Seat> addExistingTicketToExistingSeat(@RequestParam int ticketId,@RequestParam int seatId) {	      
	      return seatService.addExistingTicketToExistingSeat(ticketId, seatId);
	     
	}
	   
	   @Operation(summary = "addNewTicketToExistingSeat", description = "API is used to add New Ticket To Existing Seat")
			@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Ticket To Existing Seat in DB"),
					@ApiResponse(responseCode = "404", description = "Seat not found in the DB")})
	@PutMapping("/addNewTicketToExistingSeat")
	public ResponseStructure<Seat> addNewTicketToExistingSeat(@RequestParam int seatId,@RequestBody Ticket newTicket) {    
		return seatService.addNewTicketToExistingSeat(seatId, newTicket);
	}

}
