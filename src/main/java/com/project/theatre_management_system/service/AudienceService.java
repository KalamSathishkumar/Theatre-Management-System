package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.AudienceDao;
import com.project.theatre_management_system.dao.FoodDao;
import com.project.theatre_management_system.dto.Audience;
import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.exception.AudienceIdNotFound;
import com.project.theatre_management_system.exception.FoodIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class AudienceService {
	
	@Autowired
	AudienceDao audienceDao;
	
	@Autowired
	ResponseStructure<Audience> responseStructure;
	
	@Autowired
	ResponseStructureList<Audience> responseStructureList;
	
	@Autowired
	FoodDao foodDao;
	
	public ResponseStructure<Audience> saveAudience(Audience audience) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(audienceDao.saveAudience(audience));
	return responseStructure;
	}
	
	public ResponseStructure<Audience> updateAudienceById(int oldAudienceId, Audience newAudience) {
		 Audience  audience= audienceDao.fetchByAudienceId(oldAudienceId);
	     if(audience !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(audienceDao.updateAudienceById(oldAudienceId, newAudience));
	return responseStructure;
	     }else {
	    	 throw new AudienceIdNotFound();
	     }
		
	}
	
	public ResponseStructure<Audience> fetchByAudienceId(int audienceId) {
		     Audience  audience= audienceDao.fetchByAudienceId(audienceId);
		     if(audience !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(audienceDao.fetchByAudienceId(audienceId));
	return responseStructure;
		     }else {
		    	 throw new AudienceIdNotFound();
		     }
	}
	
	public ResponseStructureList<Audience> fetchAllAudience(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(audienceDao.fetchAllAudience());
		return responseStructureList;
	}
	
	public ResponseStructure<Audience> deleteAudienceById(int audienceId) {
		 Audience  audience= audienceDao.fetchByAudienceId(audienceId);
	     if(audience !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted from DB");
		responseStructure.setData(audienceDao.deleteAudienceById(audienceId));
	return responseStructure;
	     }else {
	    	 throw new AudienceIdNotFound();
	     }
	}
	
	public ResponseStructure<Audience> addExistingFoodToExistingAudience(int audienceId, int foodId) {
        Audience audience= audienceDao.fetchByAudienceId(audienceId);
          Food food=  foodDao.fetchByFoodId(foodId);
          
          if(audience != null) {
        	  if(food !=null) {  
        		  responseStructure.setStatusCode(HttpStatus.OK.value());
        		  responseStructure.setMessage("succesfully addded in DB");
        		  responseStructure.setData(audienceDao.addExistingFoodToExistingAudience(audienceId, foodId));
        		  return responseStructure;
        	  }else {
        		  throw new FoodIdNotFound();
        	  }
          }
        	  else {
        		  throw new AudienceIdNotFound();
        	  
          }
        
	
	}

	public ResponseStructure<Audience> addNewFoodToExistingAudience(int audienceId,Food newFood) {
		Audience audience =    audienceDao.fetchByAudienceId(audienceId);
		if(audience !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully addded in DB");
		responseStructure.setData(audienceDao.addNewFoodToExistingAudience(audienceId, newFood));
	return responseStructure;	
	}else {
		throw new AudienceIdNotFound();
	}
		
	}

}
