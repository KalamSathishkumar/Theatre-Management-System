package com.project.theatre_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.project.theatre_management_system.dao.AudienceDao;
import com.project.theatre_management_system.dao.MovieDao;
import com.project.theatre_management_system.dto.Audience;
import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.exception.AudienceIdNotFound;
import com.project.theatre_management_system.exception.MovieIdNotFound;
import com.project.theatre_management_system.util.ResponseStructure;
import com.project.theatre_management_system.util.ResponseStructureList;

@Service
public class MovieService {
	
	@Autowired
	MovieDao movieDao;
	
	@Autowired
	ResponseStructure<Movie> responseStructure;
	
	@Autowired
	ResponseStructureList<Movie> responseStructureList;
	
	@Autowired
	AudienceDao audienceDao;
	
	public ResponseStructure<Movie> saveMovie(Movie movie) {
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("succesfully data is inserted into DB");
		responseStructure.setData(movieDao.saveMovie(movie));
	   return responseStructure;
	}
	
	public ResponseStructure<Movie> updateMovieById(int oldMovieId, Movie newMovie) {
		 Movie movie= movieDao.fetchByMovieId(oldMovieId);
		 if(movie !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is updated in DB");
		responseStructure.setData(movieDao.updateMovieById(oldMovieId, newMovie));
	   return responseStructure;
		 }else {
			 throw new MovieIdNotFound();
		 }
	}
	
	public ResponseStructure<Movie> fetchByMovieId(int movieId) {
		 Movie movie= movieDao.fetchByMovieId(movieId);
		 if(movie !=null) {
		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("succesfully data is fetched from DB");
		responseStructure.setData(movieDao.fetchByMovieId(movieId));
	   return responseStructure;
		 }else {
			 throw new MovieIdNotFound();
		 }
	}
	
	public ResponseStructureList<Movie> fetchAllMovie(){
		responseStructureList.setStatusCode(HttpStatus.OK.value());
		responseStructureList.setMessage("successfully data is fetched from DB");
		responseStructureList.setData(movieDao.fetchAllMovie());
		return responseStructureList;
	
	}
	
	public ResponseStructure<Movie> deleteMovieById(int movieId) {
		 Movie movie= movieDao.fetchByMovieId(movieId);
		 if(movie !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully data is deleted into DB");
		responseStructure.setData(movieDao.deleteMovieById(movieId));
	   return responseStructure;
		 }else {
			 throw new MovieIdNotFound();
		 }
	}
	
	
	public ResponseStructure<Movie> addExistingAudienceToExistingMovie(int audienceId, int movieId) {
		 Movie movie= movieDao.fetchByMovieId(movieId);
		 Audience audience=  audienceDao.fetchByAudienceId(audienceId);
		
		 if(movie !=null) {
			 if(audience !=null) {
				 
				 responseStructure.setStatusCode(HttpStatus.OK.value());
				 responseStructure.setMessage("succesfully Added");
				 responseStructure.setData(movieDao.addExistingAudienceToExistingMovie(audienceId, movieId));
				 return responseStructure;
			 }else {
				 throw new AudienceIdNotFound();
			 }
		 }else {
			 throw new MovieIdNotFound();
		 }
	}

	public ResponseStructure<Movie> addNewAudienceToExistingMovie(int movieId, Audience newAudience) {
		 Movie movie= movieDao.fetchByMovieId(movieId);
		 if(movie !=null) {
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("succesfully Added");
		responseStructure.setData(movieDao.addNewAudienceToExistingMovie(movieId, newAudience));
	   return responseStructure;
		 }else {
			 throw new MovieIdNotFound();
		 }
}
}
