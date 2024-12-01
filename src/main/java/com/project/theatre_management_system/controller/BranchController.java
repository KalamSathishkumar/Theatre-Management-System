package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Employee;
import com.project.theatre_management_system.dto.Manager;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.service.BranchService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class BranchController {

	@Autowired
	BranchService branchService;

	@Operation(summary="Save Branch",description="API is used to Save Branch")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@PostMapping("/saveBranch")
	public ResponseStructure<Branch> saveBranch(@RequestBody Branch branch) {
		return branchService.saveBranch(branch);
	}

	   @Operation(summary = "update Branch", description = "API is used to update the Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Branch sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@PutMapping("/updateBranchById")
	public ResponseStructure<Branch> updateBranchById(@RequestParam int oldBranchId, @RequestBody Branch newBranch) {
		return branchService.updateBranchById(oldBranchId, newBranch);
	}

	   @Operation(summary = "Fetch Branch", description = "API is used to fetch the Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Branch sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@GetMapping("/fetchByBranchId")
	public ResponseStructure<Branch> fetchByBranchId(@RequestParam int branchId) {
		return branchService.fetchByBranchId(branchId);
	}
	   @Operation(summary = "Fetch All the Branches", description = "API is used to fetch all the Branches")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Branches sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@GetMapping("/fetchAllBranch")
	public ResponseStructureList<Branch> fetchAllBranch() {
		return branchService.fetchAllBranch();
	}

	   @Operation(summary = "delete Branch", description = "API is used to delete the Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Branch sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB")}) 
	@DeleteMapping("/deleteBranchById")
	public ResponseStructure<Branch> deleteBranchById(@RequestParam int branchId) {
		return branchService.deleteBranchById(branchId);
	}

	   
	   @Operation(summary = "addExistingManagerToExistingBranch", description = "API is used to add Existing Manager To Existing Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Manager To Existing Branch in DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB"),
				@ApiResponse(responseCode = "404", description = "manager not found in the DB")})
	@PutMapping("/addExistingManagerToExistingBranch")
	public ResponseStructure<Branch> addExistingManagerToExistingBranch(@RequestParam int managerId,@RequestParam int branchId) {
		return branchService.addExistingManagerToExistingBranch(managerId, branchId);
	}

	   @Operation(summary = "addNewManagerToExistingBranch", description = "API is used to add New Manager To Existing Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Manager To Existing Branch in DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@PutMapping("/addNewManagerToExistingBranch")
	public ResponseStructure<Branch> addNewManagerToExistingBranch(@RequestParam int branchId,@RequestBody Manager newManager) {
		return branchService.addNewManagerToExistingBranch(branchId, newManager);
	}
	
	   @Operation(summary = "addExistingAddressToExistingBranch", description = "API is used to add Existing Address To Existing Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Address To Existing Branch in DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Address not found in the DB")})
	@PutMapping("/addExistingAddressToExistingBranch")
	public ResponseStructure<Branch> addExistingAddressToExistingBranch(@RequestParam int branchId,@RequestParam int addressId) {	      
		 return branchService.addExistingAddressToExistingBranch(branchId, addressId);   
	}
	
	   @Operation(summary = "addNewAddressToExistingBranch", description = "API is used to add New Address To Existing Branch")
			@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Address To Existing Branch in DB"),
					@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@PutMapping("/addNewAddressToExistingBranch")
	public ResponseStructure<Branch> addNewAddressToExistingBranch(@RequestParam int branchId,@RequestBody Address address) {
   return branchService.addNewAddressToExistingBranch(branchId, address);
	}
	
	   @Operation(summary = "addExistingEmployeeToExistingBranch", description = "API is used to add Existing Employee To Existing Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Employee To Existing Branch in DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Employee not found in the DB")})
	@PutMapping("/addExistingEmployeeToExistingBranch")
	public ResponseStructure<Branch> addExistingEmployeeToExistingBranch(@RequestParam int branchId,@RequestParam int employeeId) {
		return branchService.addExistingEmployeeToExistingBranch(branchId, employeeId);
	}

	   @Operation(summary = "addNewEmployeeToExistingBranch", description = "API is used to add New Employee To Existing Branch")
			@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Employee To Existing Branch in DB"),
					@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@PutMapping("/addNewEmployeeToExistingBranch")
	public ResponseStructure<Branch> addNewEmployeeToExistingBranch(@RequestParam int branchId,@RequestBody Employee employee) {
		return branchService.addNewEmployeeToExistingBranch(branchId, employee);
	}
	
	   @Operation(summary = "addExistingScreenToExistingBranch", description = "API is used to add Existing Screen To Existing Branch")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added Existing Screen To Existing Branch in DB"),
				@ApiResponse(responseCode = "404", description = "Branch not found in the DB"),
				@ApiResponse(responseCode = "404", description = "Screen not found in the DB")})
	@PutMapping("/addExistingScreenToExistingBranch")
	public ResponseStructure<Branch> addExistingScreenToExistingBranch(@RequestParam int branchId,@RequestParam int screenId) {
		return branchService.addExistingScreenToExistingBranch(branchId, screenId);
	}

	   @Operation(summary = "addNewScreenToExistingBranch", description = "API is used to add New Screen To Existing Branch")
			@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "sucessfully added New Screen To Existing Branch in DB"),
					@ApiResponse(responseCode = "404", description = "Branch not found in the DB")})
	@PutMapping("/addNewScreenToExistingBranch")
	public ResponseStructure<Branch> addNewScreenToExistingBranch(@RequestParam int branchId,@RequestBody Screen newScreen) {
		  return branchService.addNewScreenToExistingBranch(branchId, newScreen);
	}

}
