package com.mymovieportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieportal.model.MoviePrice;

public interface MoviePriceRepository extends JpaRepository<MoviePrice, Integer>{
	
	List<MoviePrice> findByCityId(String cityId);
	
	List<MoviePrice> findByTheatreId(String theatreId);
	
	List<MoviePrice> findByMovieId(String movieId);
	
}
