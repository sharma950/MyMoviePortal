package com.mymovieportal.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.model.MoviePrice;
import com.mymovieportal.repository.MoviePriceRepository;
import com.mymovieportal.service.MoviePriceService;

@Service
public class MoviePriceServiceImpl implements MoviePriceService{

	@Autowired
	MoviePriceRepository moviePriceRepository;
	
	@Override
	public List<MoviePrice> getMoviePriceByCity(String cityId) {
		// TODO Auto-generated method stub
		List<MoviePrice> moviePriceList = moviePriceRepository.findByCityId(cityId);
		return moviePriceList;
	}

	@Override
	public List<MoviePrice> getMoviePriceByMovie(String movieId) {
		// TODO Auto-generated method stub
		List<MoviePrice> moviePriceList = moviePriceRepository.findByMovieId(movieId);
		return moviePriceList;
	}

	@Override
	public List<MoviePrice> getMoviePriceByTheatre(String theatreId) {
		// TODO Auto-generated method stub
		List<MoviePrice> moviePriceList = moviePriceRepository.findByTheatreId(theatreId);
		return moviePriceList;
	}

}
