package com.mymovieportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mymovieportal.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{
	
	@Query("")
	Movie findByMovieId(String movieId);
}
