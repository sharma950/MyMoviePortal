package com.mymovieportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mymovieportal.dto.MovieDTO;
import com.mymovieportal.model.Movie;
import com.mymovieportal.repository.MovieRepository;
import com.mymovieportal.service.MovieService;

@Controller()
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	@RequestMapping(value="/getMovies", method= RequestMethod.GET)
	public List<Movie> getAllMovies(){
		
		List<Movie> movieList = movieService.getMovies();
		if(movieList != null){
			return movieList;
		}
		return null;
	}
	
	@RequestMapping(value="/getMovie/{movieId}", method= RequestMethod.GET)
	public Movie getMovie(@PathVariable("movieId") String movieId){
		
		Movie movie = movieService.getMovie(movieId);
		if(movie != null){
			return movie;
		}
		return null;
	}
	
	@RequestMapping(value="/saveMovie/{movieId}/{movieName}", method= RequestMethod.GET)
	public Movie saveMovie(@PathVariable("movieId") String movieId, @PathVariable("movieName") String movieName){
		
		Movie movie = new Movie();
		movie.setMovieId(movieId);
		movie.setMovieName(movieName);
		Movie response = movieService.saveMovie(movie);
		return response;
	}
	
}
