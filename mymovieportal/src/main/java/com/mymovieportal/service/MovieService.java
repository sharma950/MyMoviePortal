package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.dto.MovieDTO;
import com.mymovieportal.model.Movie;

public interface MovieService {
	
	public Movie saveMovie(Movie movie);
	
	public List<Movie> getMovies();
	
	public Movie getMovie(String movieId);
	
	public Boolean updateMovie(Movie movie);
	
}
