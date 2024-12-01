package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.OwnerDao;
import com.project.theatre_management_system.dao.TheatreDao;
import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.exception.OwnerIdNotFound;
import com.project.theatre_management_system.exception.TheatreIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class OwnerService {

	@Autowired
	OwnerDao ownerDao;

	@Autowired
	ResponseStructure<Owner> responseStructure;

	@Autowired
	ResponseStructureList<Owner> responseStructureList;
	
	@Autowired
	TheatreDao theatreDao;

	public ResponseStructure<Owner> saveOwner(Owner owner) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Succesfully data is inserted into DB");
		responseStructure.setData(ownerDao.saveOwner(owner));
		return responseStructure;
	}

	public ResponseStructure<Owner> updateOwnerById(int oldOwnerId, Owner newOwner) {
		Owner owner = ownerDao.fetchByOwnerId(oldOwnerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Successfully data is updated in DB");
			responseStructure.setData(ownerDao.updateOwnerById(oldOwnerId, newOwner));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseStructure<Owner> fetchByOwnerId(int ownerId) {
		Owner owner = ownerDao.fetchByOwnerId(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Successfully data is fetched from DB");
			responseStructure.setData(ownerDao.fetchByOwnerId(ownerId));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseStructureList<Owner> fetchAllOwner() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(ownerDao.fetchAllOwner());
		return responseStructureList;
	}

	public ResponseStructure<Owner> deleteOwnerById(int ownerId) {
		Owner owner = ownerDao.fetchByOwnerId(ownerId);
		if (owner != null) {
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("succesfully data deleted from DB");
			responseStructure.setData(ownerDao.deleteOwnerById(ownerId));
			return responseStructure;
		} else {
			throw new OwnerIdNotFound();
		}
	}

	public ResponseStructure<Owner> addExistingTheatreToExistingOwner(int theatreId, int ownerId) {
		Owner owner = ownerDao.fetchByOwnerId(ownerId);
        Theatre theatre=  theatreDao.fetchByTheatreId(theatreId);
        if(owner !=null) {
        	if(theatre!=null) {
        		
        		responseStructure.setStatusCode(HttpStatus.OK.value());
        		responseStructure.setMessage("Successfully Added");
        		responseStructure.setData(ownerDao.addExistingTheatreToExistingOwner(theatreId, ownerId));
        		return responseStructure;
        	}else {
        		throw new TheatreIdNotFound();
        	}
        }else {
        	throw new OwnerIdNotFound();
        }
		
	}

	public ResponseStructure<Owner> addNewTheatreToExistingOwner(int ownerId, Theatre newTheatre) {
		Owner owner = ownerDao.fetchByOwnerId(ownerId);
		if(owner!=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Successfully Added");
		responseStructure.setData(ownerDao.addNewTheatreToExistingOwner(ownerId, newTheatre));
		return responseStructure;
		}else {
			throw new OwnerIdNotFound();
		}
	}
}
