package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.service.ScreenService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ScreenController {
	
	@Autowired
	ScreenService screenService;
	
	@Operation(summary="Save Screen",description="API is used to Save Screen")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Screen not found in the DB")})
	@PostMapping("/saveScreen")
	public ResponseStructure<Screen> saveScreen(@RequestBody Screen screen) {
	return screenService.saveScreen(screen);
	}
	
	   @Operation(summary = "update Screen", description = "API is used to update the Screen")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Screen sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB")})
	@PutMapping("/updateScreenById")
	public ResponseStructure<Screen> updateScreenById(@RequestParam int oldScreenId,@RequestBody Screen newScreen) {
          return screenService.updateScreenById(oldScreenId, newScreen);
	}
	
	   @Operation(summary = "Fetch Screen", description = "API is used to fetch the Screen")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Owner sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB")})
	@GetMapping("/fetchByScreenId")
	public ResponseStructure<Screen> fetchByScreenId(@RequestParam int screenId) {
	return	screenService.fetchByScreenId(screenId);
	}
	
	   @Operation(summary = "Fetch All the Screens", description = "API is used to fetch all the Screens")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Screens are sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB")})
	@GetMapping("/fetchAllScreen")
	public ResponseStructureList<Screen> fetchAllScreen(){
		return screenService.fetchAllScreen();
	}
	
	   @Operation(summary = "delete Screen", description = "API is used to delete the Screen")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Screen sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB")}) 
	@DeleteMapping("/deleteScreenById")
	public ResponseStructure<Screen> deleteScreenById(@RequestParam int screenId) {
		return screenService.deleteScreenById(screenId);
	}
	   @Operation(summary = "addExistingMovieToExistingScreen", description = "API is used to add Existing Movie To Existing Screen")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Movie To Existing Screen in DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Movie not found in the DB")})
	@PutMapping("/addExistingMovieToExistingScreen")
	public ResponseStructure<Screen> addExistingMovieToExistingScreen(@RequestParam   int movieId,@RequestParam  int screenId) {	      
		  return screenService.addExistingMovieToExistingScreen(movieId, screenId);   
	}
	   @Operation(summary = "addNewMovieToExistingScreen", description = "API is used to add New Movie To Existing Screen")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Movie To Existing Screen in DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB")})
	@PutMapping("/addNewMovieToExistingScreen")
	public ResponseStructure<Screen> addNewMovieToExistingScreen(@RequestParam int screenId,@RequestBody Movie newMovie) {
      return screenService.addNewMovieToExistingScreen(screenId, newMovie);
	}
	   @Operation(summary = "addExistingSeatToExistingScreen", description = "API is used to add Existing Seat To Existing Screen")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Seat To Existing Screen in DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Seat not found in the DB")})
	@PutMapping("/addExistingSeatToExistingScreen")
	public ResponseStructure<Screen> addExistingSeatToExistingScreen(@RequestParam int seatId,@RequestParam int screenId) {
		return screenService.addExistingSeatToExistingScreen(seatId, screenId);
	}
	   @Operation(summary = "addNewSeatToExistingScreen", description = "API is used to add New Seat To Existing Screen")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Seat To Existing Screen in DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB")})
	@PutMapping("/addNewSeatToExistingScreen")
	public ResponseStructure<Screen> addNewSeatToExistingScreen(@RequestParam int screenId,@RequestBody Seat newSeat) {	  
	return screenService.addNewSeatToExistingScreen(screenId, newSeat);	     
	}

}
