package com.mymovieportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mymovieportal.model.Movie;

// TODO: Auto-generated Javadoc
/**
 * The Interface MovieRepository.
 */
public interface MovieRepository extends JpaRepository<Movie, Integer> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	@Override
	List<Movie> findAll();

	/**
	 * Gets the movies by theatre.
	 *
	 * @param theatreId
	 *            the theatre id
	 * @return the movies by theatre
	 */
	@Query("from Movie where movieId in (select mtMovieId from MovieTheatre where mtTheatreId= :theatreId)")
	List<Movie> getMoviesByTheatre(@Param("theatreId") String theatreId);

}
