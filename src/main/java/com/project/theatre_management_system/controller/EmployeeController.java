package com.project.theatre_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.theatre_management_system.dto.Employee;
import com.project.theatre_management_system.service.EmployeeService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService employeeService;
	
	@Operation(summary="Save Employee",description="API is used to Save Employee")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Employee not found in the DB")})
	@PostMapping("/saveEmployee")
	public ResponseStructure<Employee> saveEmployee(@RequestBody Employee employee) {
	return employeeService.saveEmployee(employee);
	}
	
	   @Operation(summary = "update Employee", description = "API is used to update the Employee")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employee sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = "Employee not found in the DB")})
	@PutMapping("/updateEmployeeById")
	public ResponseStructure<Employee> updateEmployeeById(@RequestParam int oldEmployeeId,@RequestBody Employee newEmployee) {
          return employeeService.updateEmployeeById(oldEmployeeId, newEmployee);
	}
	
	   @Operation(summary = "Fetch Employee", description = "API is used to fetch the Employee")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Employee sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Employee not found in the DB")})
	@GetMapping("/fetchByEmployeeId")
	public ResponseStructure<Employee> fetchByEmployeeId(@RequestParam int employeeId) {
	return	employeeService.fetchByEmployeeId(employeeId);
	}
	   @Operation(summary = "Fetch All the Employees", description = "API is used to fetch all the Employees")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employees sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Employee not found in the DB")})
	@GetMapping("/fetchAllEmployee")
	public ResponseStructureList<Employee> fetchAllEmployee(){
		return employeeService.fetchAllEmployee();
	}
	
	   @Operation(summary = "delete Employee", description = "API is used to delete the Employee")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Employee sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Employee not found in the DB")}) 
	@DeleteMapping("/deleteEmployeeById")
	public ResponseStructure<Employee> deleteEmployeeById(@RequestParam int employeeId) {
		return employeeService.deleteEmployeeById(employeeId);
	}

}
