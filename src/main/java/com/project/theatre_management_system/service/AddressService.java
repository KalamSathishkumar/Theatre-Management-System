package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.AddressDao;
import com.project.theatre_management_system.dto.Address;
import com.project.theatre_management_system.exception.AddressIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class AddressService {
	
	@Autowired
	AddressDao addressDao;
	
	@Autowired
	ResponseStructure<Address> responseStructure;
	
	@Autowired
	ResponseStructureList<Address> responseStructureList;
	
	public ResponseStructure<Address> saveAddress(Address address) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("successfully data is insertde into DB");
		responseStructure.setData(addressDao.saveAddress(address));
	
	return responseStructure;
	}
	
	public ResponseStructure<Address> updateAddressById(int oldAddressId, Address newAddress) {
		  Address address=  addressDao.fetchByAddressId(oldAddressId);
	         if(address !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("successfully data is updated inDB");
		responseStructure.setData(addressDao.updateAddressById(oldAddressId, newAddress));
		
          return responseStructure;
	         }else {
	        	 throw new AddressIdNotFound();
	         }
	}
	
	public ResponseStructure<Address> fetchByAddressId(int addressId) {
		         Address address=  addressDao.fetchByAddressId(addressId);
		         if(address !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("successfully data is fetched from DB");
		responseStructure.setData(addressDao.fetchByAddressId(addressId));
          return responseStructure;
		         }else {
		        	 throw new AddressIdNotFound();
		         }
		
	}
	public ResponseStructureList<Address> fetchAllAddress(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(addressDao.fetchAllAddress());
		return responseStructureList;
	}
	
	public ResponseStructure<Address> deleteAddressById(int addressId) {
		  Address address=  addressDao.fetchByAddressId(addressId);
	         if(address !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("successfully data is deleted from DB");
		responseStructure.setData(addressDao.deleteAddressById(addressId));
          return responseStructure;
	 }else {
    	 throw new AddressIdNotFound();
     }
	}

}
