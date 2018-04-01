package com.mymovieportal.service.impl;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dto.MovieTheatreDTO;
import com.mymovieportal.model.Movie;
import com.mymovieportal.repository.MovieRepository;
import com.mymovieportal.repository.ShowtimeRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieServiceImpl.
 */
@Service
public class MovieServiceImpl {

	/** The movie repository. */
	@Autowired
	MovieRepository movieRepository;

	/** The showtime repository. */
	@Autowired
	ShowtimeRepository showtimeRepository;

	/**
	 * Gets the movies.
	 *
	 * @return the movies
	 */
	public List<Movie> getMovies() {
		// TODO Auto-generated method stub
		return movieRepository.findAll();
	}

	/**
	 * Gets the movies by theatre.
	 *
	 * @param theatreId
	 *            the theatre id
	 * @return the movies by theatre
	 */
	public List<Movie> getMoviesByTheatre(String theatreId) {
		// TODO Auto-generated method stub
		return movieRepository.getMoviesByTheatre(theatreId);
	}

	/**
	 * Gets the show time.
	 *
	 * @param movieTheatreDTO
	 *            the movie theatre DTO
	 * @return the show time
	 */
	public List<String> getShowTime(MovieTheatreDTO movieTheatreDTO) {
		String movieId = movieTheatreDTO.getMtMovieId();
		String theatreId = movieTheatreDTO.getMtTheatreId();
		List<String> str= showtimeRepository.getShowTime(movieId,theatreId);

		for (int i = 0; i < str.size(); i++) {
			String[] splited=str.get(i).split("\\s+");
			str.remove(str.get(i));
			str.add(i, splited[1]);
 		}
		return str;

	}

}
