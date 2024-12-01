package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Audience;
import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.service.AudienceService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AudienceController {

	@Autowired
	AudienceService audienceService;
	
	@Operation(summary="Save Audience",description="API is used to Save Audience")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Audience not found in the DB")})
	@PostMapping("/saveAudience")
	public ResponseStructure<Audience> saveAudience(@RequestBody Audience audience) {
	return audienceService.saveAudience(audience);
	}
	
	   @Operation(summary = "update Audience", description = "API is used to update the Audience")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Audience sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Audience not found in the DB")})
	@PutMapping("/updateAudienceById")
	public ResponseStructure<Audience> updateAudienceById(@RequestParam int oldAudienceId,@RequestBody Audience newAudience) {
          return audienceService.updateAudienceById(oldAudienceId, newAudience);
	}
	   @Operation(summary = "Fetch Audience", description = "API is used to fetch the Audience")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Audience sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Audience not found in the DB")})
	
	@GetMapping("/fetchByAudienceId")
	public ResponseStructure<Audience> fetchByAudienceId(@RequestParam int audienceId) {
	return	audienceService.fetchByAudienceId(audienceId);
	}
	
	   @Operation(summary = "Fetch All the Audiences", description = "API is used to fetch all the Audiences")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Audiences sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Audience not found in the DB")})
	@GetMapping("/fetchAllAudience")
	public ResponseStructureList<Audience> fetchAllAudience(){
		return audienceService.fetchAllAudience();
	}
	
	   @Operation(summary = "delete Audience", description = "API is used to delete the Audience")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Audience sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Audience not found in the DB")}) 
	@DeleteMapping("/deleteAudienceById")
	public ResponseStructure<Audience> deleteAudienceById(@RequestParam int audienceId) {
		return audienceService.deleteAudienceById(audienceId);
	}
	
	   @Operation(summary = "addExistingFoodToExistingAudience", description = "API is used to add Existing Food To Existing Audience")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Food To Existing Audience in DB"),
				@ApiResponse(responseCode = "404", description = "Audience not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Food not found in the DB")})
	@PutMapping("/addExistingFoodToExistingAudience")
	public ResponseStructure<Audience> addExistingFoodToExistingAudience(@RequestParam int audienceId,@RequestParam int foodId) {	
		return audienceService.addExistingFoodToExistingAudience(audienceId, foodId);
	}
	   @Operation(summary = "addNewFoodToExistingAudience", description = "API is used to add New Food To ExistingAudience")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Food To Existing Audience in DB"),
				@ApiResponse(responseCode = "404", description = "Audience not found in the DB")})
	@PutMapping("/addNewFoodToExistingAudience")
	public ResponseStructure<Audience> addNewFoodToExistingAudience(@RequestParam int audienceId,@RequestBody Food newFood) {	
	return audienceService.addNewFoodToExistingAudience(audienceId, newFood);	
	}
}
