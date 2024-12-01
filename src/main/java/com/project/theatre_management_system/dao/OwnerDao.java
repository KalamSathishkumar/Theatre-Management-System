package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Owner;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.repo.OwnerRepo;

@Repository
public class OwnerDao {
	
	@Autowired
	OwnerRepo ownerRepo;
	
	@Autowired
	TheatreDao theatreDao;
	
	
	
	public Owner saveOwner(Owner owner) {
	return ownerRepo.save(owner);
	}
	
	public Owner updateOwnerById(int oldOwnerId, Owner newOwner) {
		
		
		newOwner.setOwnerId(oldOwnerId);
//	return	ownerRepo.save(newOwner);
	return	saveOwner(newOwner);
	}
	
	public Owner fetchByOwnerId(int ownerId) {
	    Optional<Owner> dbOwner=ownerRepo.findById(ownerId);
	     if(dbOwner.isPresent()) {
	    	 return dbOwner.get();
	     }else {
	    	 return null;
	     }
	    
	}
	
	public List<Owner> fetchAllOwner(){
		return ownerRepo.findAll();
	}
	
	public Owner deleteOwnerById(int ownerId) {
		Owner owner=fetchByOwnerId(ownerId);
		ownerRepo.delete(owner);
		return owner;
	}
	
	public Owner addExistingTheatreToExistingOwner(int theatreId,int ownerId) {	      
		Owner owner=fetchByOwnerId(ownerId);
		Theatre theatre=theatreDao.fetchByTheatreId(theatreId);
		owner.setTheatre(theatre);
		return saveOwner(owner);	     
	}
	
	public Owner addNewTheatreToExistingOwner(int ownerId,Theatre newTheatre) {
    Owner owner=fetchByOwnerId(ownerId);
    owner.setTheatre(newTheatre);
    return saveOwner(owner);
	}
	
}
