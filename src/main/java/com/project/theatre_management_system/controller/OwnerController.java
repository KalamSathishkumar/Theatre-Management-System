package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.service.OwnerService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class OwnerController {
	
	@Autowired
	OwnerService ownerService;
	
	@Operation(summary="Save Owner",description="API is used to Save Owner")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "owner not found in the DB")})
	
	@PostMapping("/saveOwner")
	public ResponseStructure<Owner> saveOwner(@RequestBody Owner owner) {
	return ownerService.saveOwner(owner);
	}

	   @Operation(summary = "update Owner", description = "API is used to update the owner")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Owner sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "owner not found in the DB")})
	@PutMapping("/updateOwnerById")
	public ResponseStructure<Owner> updateOwnerById(@RequestParam int oldOwnerId,@RequestBody Owner newOwner) {
          return ownerService.updateOwnerById(oldOwnerId, newOwner);
	}
	
	   @Operation(summary = "Fetch Owner", description = "API is used to fetch the owner")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Owner sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "owner not found in the DB")})
	
	@GetMapping("/fetchByOwnerId")
	public ResponseStructure<Owner> fetchByOwnerId(@RequestParam int ownerId) {
	return	ownerService.fetchByOwnerId(ownerId);
	}
	

	   @Operation(summary = "Fetch All the Owners", description = "API is used to fetch all the owners")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Owners sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "owner not found in the DB")})
	@GetMapping("/fetchAllOwner")
	public ResponseStructureList<Owner> fetchAllOwner(){
		return ownerService.fetchAllOwner();
	}
	

	   @Operation(summary = "delete Owner", description = "API is used to delete the owner")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Owner sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "owner not found in the DB")})  
	@DeleteMapping("/deleteOwnerById")
	public ResponseStructure<Owner> deleteOwnerById(@RequestParam int ownerId) {
		return ownerService.deleteOwnerById(ownerId);
	}
	
	   @Operation(summary = "addExistingTheatreToExistingOwner", description = "API is used to add ExistingTheatre To ExistingOwner")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully addede Existing Theatre To Existing Owner in DB"),
				@ApiResponse(responseCode = "404", description = "owner not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Theatre not found in the DB")})
	@PutMapping("/addExistingTheatreToExistingOwner")
	public ResponseStructure<Owner> addExistingTheatreToExistingOwner(@RequestParam int theatreId,@RequestParam int ownerId) {
		return ownerService.addExistingTheatreToExistingOwner(theatreId, ownerId);
	}
	
	   
	   @Operation(summary = "addNewTheatreToExistingOwner", description = "API is used to add New Theatre To Existing Owner")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Theatre To Existing Owner in DB"),
				@ApiResponse(responseCode = "404", description = "owner not found in the DB")})
	@PutMapping("/addNewTheatreToExistingOwner")
	public ResponseStructure<Owner> addNewTheatreToExistingOwner(@RequestParam int ownerId,@RequestBody Theatre newTheatre) {
		return ownerService.addNewTheatreToExistingOwner(ownerId, newTheatre);
	}

}
