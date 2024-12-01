package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.BranchDao;
import com.project.theatre_management_system.dao.TheatreDao;
import com.project.theatre_management_system.dto.Branch;
import com.project.theatre_management_system.dto.Theatre;
import com.project.theatre_management_system.exception.BranchIdNotFound;
import com.project.theatre_management_system.exception.TheatreIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class TheatreService {

	@Autowired
	TheatreDao theatreDao;
	
	@Autowired
	ResponseStructure<Theatre> responseStructure;
      
	@Autowired
	ResponseStructureList<Theatre> responseStructureList;
	
	@Autowired
	BranchDao branchDao;
	
	public ResponseStructure<Theatre> saveTheatre(Theatre theatre) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(theatreDao.saveTheatre(theatre));
	   return responseStructure;
	}

	public ResponseStructure<Theatre> updateTheatreById(int oldTheatreId, Theatre newTheatre) {
          
		  Theatre theatre= theatreDao.fetchByTheatreId(oldTheatreId);
		   if(theatre !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(theatreDao.updateTheatreById(oldTheatreId, newTheatre));
	   return responseStructure;
		   }else {
			   throw new TheatreIdNotFound();
		   }
	}

	public ResponseStructure<Theatre> fetchByTheatreId(int theatreId) {
		   Theatre theatre= theatreDao.fetchByTheatreId(theatreId);
		   if(theatre !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(theatreDao.fetchByTheatreId(theatreId));
	   return responseStructure;
		   }else {
			   throw new TheatreIdNotFound();
		   }
	}

	public ResponseStructureList<Theatre> fetchAllTheatre() {
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(theatreDao.fetchAllTheatre());
		return responseStructureList;
	}

	public ResponseStructure<Theatre> deleteTheatreById(int theatreId) {
		  Theatre theatre= theatreDao.fetchByTheatreId(theatreId);
		   if(theatre !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted from DB");
		responseStructure.setData(theatreDao.deleteTheatreById(theatreId));
	   return responseStructure;
		   }else {
			   throw new TheatreIdNotFound();
		   }

	}

	public ResponseStructure<Theatre> addExistingBranchToExistingTheatre(int branchId, int theatreId) {
		Theatre theatre= theatreDao.fetchByTheatreId(theatreId);
       Branch branch   =  branchDao.fetchByBranchId(branchId);
       
       if(theatre !=null) {
    	   if(branch !=null) {
    		   
    		   responseStructure.setStatusCode(HttpStatus.OK.value());
    		   responseStructure.setMessage("succesfully added");
    		   responseStructure.setData(theatreDao.addExistingBranchToExistingTheatre(branchId, theatreId));
    		   return responseStructure;
    	   }else {
    		   throw new BranchIdNotFound();
    	   }
       }else {
    	   throw new TheatreIdNotFound();
       }

	}

	public ResponseStructure<Theatre> addNewBranchToExistingTheatre(int theatreId, Branch newBranch) {
		Theatre theatre= theatreDao.fetchByTheatreId(theatreId);
		if(theatre!=null) {
			
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("succesfully added");
			responseStructure.setData(theatreDao.addNewBranchToExistingTheatre(theatreId, newBranch));
			return responseStructure;
		}else {
			throw new TheatreIdNotFound();
		}
	}

}
