package com.mymovieportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.model.Movie;
import com.mymovieportal.repository.MovieRepository;
import com.mymovieportal.service.MovieService;

@Service
public class MovieServiceImpl implements MovieService{

	@Autowired
	MovieRepository movieRepository;
	
	@Override
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		List<Movie> movie = movieRepository.findAll();
		return movie;
	}

	@Override
	public Boolean updateMovie(Movie movie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Movie getMovie(String movieId) {
		// TODO Auto-generated method stub
		Movie movie = movieRepository.findByMovieId(movieId);
		return null;
	}

	@Override
	public Movie saveMovie(Movie movie) {
		// TODO Auto-generated method stub
		
		return null;
	}
	
}
