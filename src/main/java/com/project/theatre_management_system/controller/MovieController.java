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
import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.service.MovieService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@Operation(summary="Save Movie",description="API is used to Save Movie")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Movie not found in the DB")})
	@PostMapping("/saveMovie")
	public ResponseStructure<Movie> saveMovie(@RequestBody Movie movie) {
	return movieService.saveMovie(movie);
	}
	
	   @Operation(summary = "update Movie", description = "API is used to update the Movie")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Movie sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Movie not found in the DB")})
	@PutMapping("/updateMovieById")
	public ResponseStructure<Movie> updateMovieById(@RequestParam int oldMovieId,@RequestBody Movie newMovie) {
          return movieService.updateMovieById(oldMovieId, newMovie);
	}
	   @Operation(summary = "Fetch Movie", description = "API is used to fetch the Movie")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Movie sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Movie not found in the DB")})
	@GetMapping("/fetchByMovieId")
	public ResponseStructure<Movie> fetchByMovieId(@RequestParam int movieId) {
	return	movieService.fetchByMovieId(movieId);
	}
	
	   @Operation(summary = "Fetch All the Movies", description = "API is used to fetch all the Movies")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Movies sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Movie not found in the DB")})
	@GetMapping("/fetchAllMovie")
	public ResponseStructureList<Movie> fetchAllMovie(){
		return movieService.fetchAllMovie();
	}
	
	   @Operation(summary = "delete Movies", description = "API is used to delete the Movie")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Movies sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Movie not found in the DB")}) 
	@DeleteMapping("/deleteMovieById")
	public ResponseStructure<Movie> deleteMovieById(@RequestParam int movieId) {
		return movieService.deleteMovieById(movieId);
	}
	
	   @Operation(summary = "addExistingAudienceToExistingMovie", description = "API is used to add Existing Audience To Existing Movie")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Audience To Existing Movie in DB"),
				@ApiResponse(responseCode = "404", description = "Movie not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Audience not found in the DB")})
	    @PutMapping("/addExistingAudienceToExistingMovie")
	public ResponseStructure<Movie> addExistingAudienceToExistingMovie(@RequestParam int audienceId,@RequestParam int movieId) {
		return movieService.addExistingAudienceToExistingMovie(audienceId, movieId);
	}
	   
	   @Operation(summary = "addNewAudienceToExistingMovie", description = "API is used to add New Audience To Existing Movie")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Audience To Existing Movie in DB"),
				@ApiResponse(responseCode = "404", description = "Movie not found in the DB")})
    @PutMapping("/addNewAudienceToExistingMovie")
	public ResponseStructure<Movie> addNewAudienceToExistingMovie(@RequestParam int movieId,@RequestBody Audience newAudience) {
		return movieService.addNewAudienceToExistingMovie(movieId, newAudience);
	}

}
