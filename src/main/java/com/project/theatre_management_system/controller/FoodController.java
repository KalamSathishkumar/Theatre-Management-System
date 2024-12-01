package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.service.FoodService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class FoodController {
	
	@Autowired
	FoodService foodService;
	
	@Operation(summary="Save Food",description="API is used to Save Food")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Food not found in the DB")})
	@PostMapping("/saveFood")
	public ResponseStructure<Food> saveFood(@RequestBody Food food) {
	return foodService.saveFood(food);
	}
	
	   @Operation(summary = "update Food", description = "API is used to update the Food")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Food sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Food not found in the DB")})
	@PutMapping("/updateFoodById")
	public ResponseStructure<Food> updateFoodById(@RequestParam int oldFoodId,@RequestBody Food newFood) {
          return foodService.updateFoodById(oldFoodId, newFood);
	}
	
	   @Operation(summary = "Fetch Food", description = "API is used to fetch the Food")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Food sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Food not found in the DB")})
	@GetMapping("/fetchByFoodId")
	public ResponseStructure<Food> fetchByFoodId(@RequestParam int foodId) {
	return	foodService.fetchByFoodId(foodId);
	}
	   
	   @Operation(summary = "Fetch All the Foods", description = "API is used to fetch all the Foods")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Foods sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Food not found in the DB")})
	@GetMapping("/fetchAllFood")
	public ResponseStructureList<Food> fetchAllFood(){
		return foodService.fetchAllFood();
	}
	
	   @Operation(summary = "delete Food", description = "API is used to delete the Food")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Food sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Food not found in the DB")}) 
	@DeleteMapping("/deleteFoodById")
	public ResponseStructure<Food> deleteFoodById(@RequestParam int foodId) {
		return foodService.deleteFoodById(foodId);
	}

}
