package com.mymovieportal.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mymovieportal.model.Showtime;

// TODO: Auto-generated Javadoc
/**
 * The Interface ShowtimeRepository.
 */
public interface ShowtimeRepository extends JpaRepository<Showtime, Integer> {

	/**
	 * Gets the show time.
	 *
	 * @return the show time
	 */
	@Query("Select DATE_FORMAT(showTimeValue, '%d-%m-%y %h:%i:%s') from Showtime where showTimeId in"
			+ "(select mtShowtimeId from MovieTheatre where mtMovieId= :movieId and mtTheatreId= :theatreId)")
	List<String> getShowTime(@Param("movieId") String movieId, @Param("theatreId") String theatreId);

	/*
	 * @Query("select mtShowtimeId from MovieTheatre where where mtMovieId=:movieId and mtTheatreId=:theatreId)"
	 * ) String getShowId(String movieId, String theatreId);
	 */

}
