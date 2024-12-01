package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.service.ManagerService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class ManagerController {	

	@Autowired
	ManagerService managerService;
	
	@Operation(summary="Save Manager",description="API is used to Save Manager")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Manager not found in the DB")})
	@PostMapping("/saveManager")
	public ResponseStructure<Manager> saveManager(@RequestBody Manager manager) {
	return managerService.saveManager(manager);
	}
	
	   @Operation(summary = "update Manager", description = "API is used to update the Manager")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Manager sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Manager not found in the DB")})
	@PutMapping("/updateManagerById")
	public ResponseStructure<Manager> updateManagerById(@RequestParam int oldManagerId,@RequestBody Manager newManager) {
          return managerService.updateManagerById(oldManagerId, newManager);
	}
	
	   @Operation(summary = "Fetch Manager", description = "API is used to fetch the Manager")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Manager sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Manager not found in the DB")})
	@GetMapping("/fetchByManagerId")
	public ResponseStructure<Manager> fetchByManagerId(@RequestParam int managerId) {
	return	managerService.fetchByManagerId(managerId);
	}
	
	   @Operation(summary = "Fetch All the Managers", description = "API is used to fetch all the Managers")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Managers sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Manager not found in the DB")})
	@GetMapping("/fetchAllManager")
	public ResponseStructureList<Manager> fetchAllManager(){
		return managerService.fetchAllManager();
	}
	
	   @Operation(summary = "delete Manager", description = "API is used to delete the Manager")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Manager sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Manager not found in the DB")}) 
	@DeleteMapping("/deleteManagerById")
	public ResponseStructure<Manager> deleteManagerById(@RequestParam int managerId) {
		return managerService.deleteManagerById(managerId);
	}

}
