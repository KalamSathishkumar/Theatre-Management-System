package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.service.TheatreService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class TheatreController {

	@Autowired
	TheatreService theatreService;

	@Operation(summary="Save Theatre",description="API is used to Save Theatre")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Theatre not found in the DB")})
	@PostMapping("/saveTheatre")
	public ResponseStructure<Theatre> saveTheatre(@RequestBody Theatre theatre) {
		return theatreService.saveTheatre(theatre);
	}

	   @Operation(summary = "update Theatre", description = "API is used to update the Theatre")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Theatre sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Theatre not found in the DB")})
	@PutMapping("/updateTheatreById")
	public ResponseStructure<Theatre> updateTheatreById(@RequestParam int oldTheatreId, @RequestBody Theatre newTheatre) {
		return theatreService.updateTheatreById(oldTheatreId, newTheatre);
	}

	   @Operation(summary = "Fetch Theatre", description = "API is used to fetch the Theatre")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Theatre sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Theatre not found in the DB")})
	@GetMapping("/fetchByTheatreId")
	public ResponseStructure<Theatre> fetchByTheatreId(@RequestParam int theatreId) {
		return theatreService.fetchByTheatreId(theatreId);
	}

	   @Operation(summary = "Fetch All the Theatres", description = "API is used to fetch all the Theatres")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Theatres sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Theatre not found in the DB")})
	@GetMapping("/fetchAllTheatre")
	public ResponseStructureList<Theatre> fetchAllTheatre() {
		return theatreService.fetchAllTheatre();
	}

	   @Operation(summary = "delete Theatre", description = "API is used to delete the Theatre")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Theatre sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Theatre not found in the DB")}) 
	@DeleteMapping("/deleteTheatreById")
	public ResponseStructure<Theatre> deleteTheatreById(@RequestParam int theatreId) {
		return theatreService.deleteTheatreById(theatreId);
	}

	   @Operation(summary = "addExistingBranchToExistingTheatre", description = "API is used to add Existing Branch To Existing Theatre")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Branch To Existing Theatre in DB"),
				@ApiResponse(responseCode = "404", description = "Theatre not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@PutMapping("/addExistingBranchToExistingTheatre")
	public ResponseStructure<Theatre> addExistingBranchToExistingTheatre(@RequestParam int branchId,@RequestParam int theatreId) {
		return theatreService.addExistingBranchToExistingTheatre(branchId, theatreId);
	}
	
	   @Operation(summary = "addNewBranchToExistingTheatre", description = "API is used to add New Branch To Existing Theatre")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Branch To Existing Theatre in DB"),
				@ApiResponse(responseCode = "404", description = "Theatre not found in the DB")})
	@PutMapping("/addNewBranchToExistingTheatre")
	public ResponseStructure<Theatre> addNewBranchToExistingTheatre(@RequestParam int theatreId,@RequestBody Branch newBranch) {
		return theatreService.addNewBranchToExistingTheatre(theatreId, newBranch);
	}

}
