package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.model.MoviePrice;

public interface MoviePriceService {
	
	public List<MoviePrice> getMoviePriceByCity(String cityId);
	
	public List<MoviePrice> getMoviePriceByMovie(String movieId);
	
	public List<MoviePrice> getMoviePriceByTheatre(String theatreId);
}
