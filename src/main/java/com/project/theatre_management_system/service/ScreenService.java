package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.MovieDao;
import com.project.theatre_management_system.dao.ScreenDao;
import com.project.theatre_management_system.dao.SeatDao;
import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.exception.ForeignKeyConstraintViolationException;
import com.project.theatre_management_system.exception.MovieIdNotFound;
import com.project.theatre_management_system.exception.ScreenIdNotFound;
import com.project.theatre_management_system.exception.SeatIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class ScreenService {
	
	@Autowired
	ScreenDao screenDao;
	
	@Autowired
	ResponseStructure<Screen> responseStructure;
	
	@Autowired
	ResponseStructureList<Screen> responseStructureList;
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	SeatDao seatDao;
	
	public ResponseStructure<Screen> saveScreen(Screen screen) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(screenDao.saveScreen(screen));
	   return responseStructure;
	}
	
	public ResponseStructure<Screen> updateScreenById(int oldScreenId, Screen newScreen) {
		 Screen screen=screenDao.fetchByScreenId(oldScreenId);
		 if(screen !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(screenDao.updateScreenById(oldScreenId, newScreen));
	   return responseStructure;
		 }else {
			 throw new ScreenIdNotFound();
		 }
 
	}
	
	public ResponseStructure<Screen> fetchByScreenId(int screenId) {
		 Screen screen=screenDao.fetchByScreenId(screenId);
		 if(screen !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(screenDao.fetchByScreenId(screenId));
	   return responseStructure;
		 }else {
			 throw new ScreenIdNotFound();
		 }
	}
	
	public ResponseStructureList<Screen> fetchAllScreen(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(screenDao.fetchAllScreen());
		return responseStructureList;
	}
	
	public ResponseStructure<Screen> deleteScreenById(int screenId) {
		 Screen screen=screenDao.fetchByScreenId(screenId);
		 if(screen !=null) {
			 try {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted in DB");
		responseStructure.setData(screenDao.deleteScreenById(screenId));
	   return responseStructure;
			 }catch(org.springframework.dao.DataIntegrityViolationException e) {
				 throw new ForeignKeyConstraintViolationException();
			 }
		 }else {
			 throw new ScreenIdNotFound();
		 }
	
	}
	
	public ResponseStructure<Screen> addExistingMovieToExistingScreen(int movieId,int screenId) {
		 Screen screen=screenDao.fetchByScreenId(screenId);
	     Movie movie= movieDao.fetchByMovieId(movieId);
	     
	     if(screen !=null) {
	    	 if(movie !=null) {
	    		 
	    		 responseStructure.setStatusCode(HttpStatus.OK.value());
	    		 responseStructure.setMessage("successfully Added");
	    		 responseStructure.setData(screenDao.addExistingMovieToExistingScreen(movieId, screenId));
	    		 return responseStructure;  
	    	 }else {
	    		 throw new MovieIdNotFound();
	    	 }
	     }else {
	    	 throw new ScreenIdNotFound();
	     }
	}
	
	public ResponseStructure<Screen> addNewMovieToExistingScreen(int screenId,Movie newMovie) {
		 Screen screen=screenDao.fetchByScreenId(screenId);
		 if(screen !=null) {
			 
			 responseStructure.setStatusCode(HttpStatus.OK.value());
			 responseStructure.setMessage("succesfully added");
			 responseStructure.setData(screenDao.addNewMovieToExistingScreen(screenId, newMovie));
			 return responseStructure;
		 }else {
			 throw new ScreenIdNotFound();
		 }
	}
	
	public ResponseStructure<Screen> addExistingSeatToExistingScreen(int seatId, int screenId) {
		 Screen screen=screenDao.fetchByScreenId(screenId);
		 Seat seat= seatDao.fetchBySeatId(seatId);
		 if(screen!=null) {
		 if(seat!=null) {
			 responseStructure.setStatusCode(HttpStatus.OK.value());
			 responseStructure.setMessage("succesfully addded");
			 responseStructure.setData(screenDao.addExistingSeatToExistingScreen(seatId, screenId));
			 return responseStructure;	 
		 }else {
			 throw new SeatIdNotFound();
		 }
	}else {
		throw new ScreenIdNotFound();
	}
	}

	public ResponseStructure<Screen> addNewSeatToExistingScreen(int screenId,Seat newSeat) {
		 Screen screen=screenDao.fetchByScreenId(screenId);
		 if(screen !=null) {
			 
			 responseStructure.setStatusCode(HttpStatus.OK.value());
			 responseStructure.setMessage("succesfully added");
			 responseStructure.setData(screenDao.addNewSeatToExistingScreen(screenId, newSeat));
			 return responseStructure;	     
		 }else {
			 throw new ScreenIdNotFound();
		 }
	}

}
