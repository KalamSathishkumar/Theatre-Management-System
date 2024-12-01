package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.repo.AddressRepo;

@Repository
public class AddressDao {
	
	@Autowired
	AddressRepo addressRepo;
	
	public Address saveAddress(Address Address) {
	return addressRepo.save(Address);
	}
	
	public Address updateAddressById(int oldAddressId, Address newAddress) {
		newAddress.setAddressId(oldAddressId);
//	return	AddressRepo.save(newAddress);
	return	saveAddress(newAddress);
	}
	
	public Address fetchByAddressId(int addressId) {
		Optional<Address> dbAddress=addressRepo.findById(addressId);
		if(dbAddress.isPresent()) {
			return dbAddress.get();
		}else {
			return null;
		}
	}
	
	public List<Address> fetchAllAddress(){
		return addressRepo.findAll();
	}
	
	public Address deleteAddressById(int AddressId) {
		Address Address=fetchByAddressId(AddressId);
		addressRepo.delete(Address);
		return Address;
	}

}
