package com.project.theatre_management_system.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.theatre_management_system.dto.Audience;
import com.project.theatre_management_system.dto.Movie;
import com.project.theatre_management_system.dto.Screen;
import com.project.theatre_management_system.dto.Seat;
import com.project.theatre_management_system.repo.MovieRepo;

@Repository
public class MovieDao {

	@Autowired
	MovieRepo movieRepo;

	@Autowired
	AudienceDao audienceDao;

	public Movie saveMovie(Movie movie) {
		return movieRepo.save(movie);
	}

	public Movie updateMovieById(int oldMovieId, Movie newMovie) {
		newMovie.setMovieId(oldMovieId);
//	return	movieRepo.save(newMovie);
		return saveMovie(newMovie);
	}

	public Movie fetchByMovieId(int movieId) {
		Optional<Movie> dbMovie= movieRepo.findById(movieId);
		if(dbMovie.isPresent()) {
			return dbMovie.get();
		}else {
			return null;
		}
	}

	public List<Movie> fetchAllMovie() {
		return movieRepo.findAll();
	}

	public Movie deleteMovieById(int movieId) {
		Movie movie = fetchByMovieId(movieId);
		movieRepo.delete(movie);
		return movie;
	}

	public Movie addExistingAudienceToExistingMovie(int audienceId, int movieId) {
		Movie movie = fetchByMovieId(movieId);
		Audience audience = audienceDao.fetchByAudienceId(audienceId);
		List<Audience> list = movie.getAudience();
		list.add(audience);
		movie.setAudience(list);
		return saveMovie(movie);

	}

	public Movie addNewAudienceToExistingMovie(int movieId, Audience newAudience) {
		Movie movie = fetchByMovieId(movieId);
		List<Audience> list = movie.getAudience();
		list.add(newAudience);
		return saveMovie(movie);
	}

	
}
