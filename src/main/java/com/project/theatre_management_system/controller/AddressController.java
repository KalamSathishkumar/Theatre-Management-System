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
import com.project.theatre_management_system.service.AddressService;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
public class AddressController {
	
	@Autowired
	AddressService addressService;
	
	@Operation(summary="Save Address",description="API is used to Save Address")
	@ApiResponses(value = { @ApiResponse(responseCode = "201", description = "Successfully created"),
			@ApiResponse(responseCode = "404", description = "Address not found in the DB")})
	@PostMapping("/saveAddress")
	public ResponseStructure<Address> saveAddress(@RequestBody Address address) {
	return addressService.saveAddress(address);
	}
	
	   @Operation(summary = "update Address", description = "API is used to update the  Address")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Owner sucessfully updated in DB"),
				@ApiResponse(responseCode = "404", description = " Address not found in the DB")})
	@PutMapping("/updateAddressById")
	public ResponseStructure<Address> updateAddressById(@RequestParam int oldAddressId,@RequestBody Address newAddress) {
          return addressService.updateAddressById(oldAddressId, newAddress);
	}
	
	   @Operation(summary = "Fetch Address", description = "API is used to fetch the Address")
		@ApiResponses(value = { @ApiResponse(responseCode = "302", description = "Address sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Address not found in the DB")})
	@GetMapping("/fetchByAddressId")
	public ResponseStructure<Address> fetchByAddressId(@RequestParam int addressId) {
	return	addressService.fetchByAddressId(addressId);
	}
	
	   @Operation(summary = "Fetch All the Address", description = "API is used to fetch all the Address")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Addresses sucessfully fetched from DB"),
				@ApiResponse(responseCode = "404", description = "Address not found in the DB")})
	@GetMapping("/fetchAllAddress")
	public ResponseStructureList<Address> fetchAllAddress(){
		return addressService.fetchAllAddress();
	}
	   
	
	   @Operation(summary = "delete Address", description = "API is used to delete the Address")
		@ApiResponses(value = { @ApiResponse(responseCode = "200", description = "Address sucessfully deleted from DB"),
				@ApiResponse(responseCode = "404", description = "Address not found in the DB")}) 
	@DeleteMapping("/deleteAddressById")
	public ResponseStructure<Address> deleteAddressById(@RequestParam int addressId) {
		return addressService.deleteAddressById(addressId);
	}

}
