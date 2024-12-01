package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Audience;
import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.repo.AudienceRepo;

@Repository
public class AudienceDao {

	@Autowired
	AudienceRepo audienceRepo;
	
	@Autowired
	FoodDao foodDao;

	public Audience saveAudience(Audience audience) {
		return audienceRepo.save(audience);
	}

	public Audience updateAudienceById(int oldAudienceId, Audience newAudience) {
		newAudience.setAudienceId(oldAudienceId);
//	return	audienceRepo.save(newAudience);
		return saveAudience(newAudience);
	}

	public Audience fetchByAudienceId(int audienceId) {
	    Optional<Audience> dbAudience= audienceRepo.findById(audienceId);
	    if(dbAudience.isPresent()) {
	    	return dbAudience.get();
	    }else{
	       return null;
	    }
	    
	}

	public List<Audience> fetchAllAudience() {
		return audienceRepo.findAll();
	}

	public Audience deleteAudienceById(int audienceId) {
		Audience audience = fetchByAudienceId(audienceId);
		audienceRepo.delete(audience);
		return audience;
	}
	
	public Audience addExistingFoodToExistingAudience(int audienceId, int foodId) {	
		   Audience audience= fetchByAudienceId(audienceId);
		 Food food=foodDao.fetchByFoodId(foodId);
		    List<Food> list=audience.getFood();
		    list.add(food);
		    return saveAudience(audience);
	}

	public Audience addNewFoodToExistingAudience(int audienceId,Food newFood) {
		Audience audience=  fetchByAudienceId(audienceId);
		List<Food>list=audience.getFood();
		list.add(newFood);
		return saveAudience(audience);
		
	}

}
