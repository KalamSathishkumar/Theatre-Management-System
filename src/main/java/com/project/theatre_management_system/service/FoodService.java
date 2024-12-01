package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.FoodDao;
import com.project.theatre_management_system.dto.Food;
import com.project.theatre_management_system.exception.FoodIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class FoodService {

	@Autowired
	FoodDao foodDao;
	
	@Autowired
	ResponseStructure<Food> responseStructure;
	@Autowired
	ResponseStructureList<Food> responseStructureList;
	
	public ResponseStructure<Food> saveFood(Food food) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(foodDao.saveFood(food));
	   return responseStructure;
	}
	
	public ResponseStructure<Food> updateFoodById(int oldFoodId, Food newFood) {
	      Food food=foodDao.fetchByFoodId(oldFoodId);
	      if(food !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(foodDao.updateFoodById(oldFoodId, newFood));
      	return responseStructure;
	      }else {
	    	  throw new FoodIdNotFound();
	      }

	}
	
	public ResponseStructure<Food> fetchByFoodId(int foodId) {
		      Food food=foodDao.fetchByFoodId(foodId);
		      if(food !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(foodDao.fetchByFoodId(foodId));
	   return responseStructure;
		      }else {
		    	  throw new FoodIdNotFound();
		      }
	}
	
	public ResponseStructureList<Food> fetchAllFood(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(foodDao.fetchAllFood());
		return responseStructureList;
		
	}
	
	public ResponseStructure<Food> deleteFoodById(int foodId) {
	      Food food=foodDao.fetchByFoodId(foodId);
	      if(food !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted from DB");
		responseStructure.setData(foodDao.deleteFoodById(foodId));
	return responseStructure;
	      }else {
	    	  throw new FoodIdNotFound();
	      }

	}
}
