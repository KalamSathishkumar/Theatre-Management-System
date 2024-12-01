package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.repo.ScreenRepo;

@Repository
public class ScreenDao {
	
	@Autowired
	ScreenRepo screenRepo;
	
	@Autowired
	 MovieDao movieDao;
	
	@Autowired
	SeatDao seatDao;
	
	public Screen saveScreen(Screen screen) {
	return screenRepo.save(screen);
	}
	
	public Screen updateScreenById(int oldScreenId, Screen newScreen) {
		newScreen.setScreenId(oldScreenId);
//	return	screenRepo.save(newScreen);
	return	saveScreen(newScreen);
	}
	
	public Screen fetchByScreenId(int screenId) {
	Optional<Screen> dbScreen=screenRepo.findById(screenId);
	if(dbScreen.isPresent()) {
		return dbScreen.get();
	}else {
		return null;
	}
	}
	
	public List<Screen> fetchAllScreen(){
		return screenRepo.findAll();
	}
	
	public Screen deleteScreenById(int screenId) {
		Screen screen=fetchByScreenId(screenId);
		screenRepo.delete(screen);
		return screen;
	}
	
	public Screen addExistingMovieToExistingScreen(int movieId,int screenId) {	      
		   Screen screen= fetchByScreenId(screenId);
		    Movie movie=  movieDao.fetchByMovieId(movieId);		
		  screen.setMovie(movie);
		  return saveScreen(screen);     
	}
	
	public Screen addNewMovieToExistingScreen(int screenId,Movie newMovie) {
     Screen screen=fetchByScreenId(screenId);
     screen.setMovie(newMovie);
     return saveScreen(screen);
	}
	
	public Screen addExistingSeatToExistingScreen(int seatId, int screenId) {
		 Screen screen=fetchByScreenId(screenId);
	       Seat seat=seatDao.fetchBySeatId(screenId); 
		List<Seat>list=screen.getSeat();
		list.add(seat);
		screen.setSeat(list);
		return saveScreen(screen);
	}

	public Screen addNewSeatToExistingScreen(int screenId,Seat newSeat) {
		     Screen screen= fetchByScreenId(screenId);
		          List<Seat>list=screen.getSeat();
		          list.add(newSeat);
		          return saveScreen(screen);
		     
	}

}
