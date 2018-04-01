package com.mymovieportal.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieportal.dto.MovieTheatreDTO;
import com.mymovieportal.model.Movie;
import com.mymovieportal.service.impl.MovieServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieController.
 */
@RestController
@RequestMapping("/mymovieportal/movie")
public class MovieController {

	/** The movie service impl. */
	@Autowired
	MovieServiceImpl movieServiceImpl;

	/**
	 * Gets the movies.
	 *
	 * @return the movies
	 */
	@RequestMapping(value = "/getMovies", method = RequestMethod.GET)
	public @ResponseBody List<Movie> getMovies() {

		List<Movie> movieList = movieServiceImpl.getMovies();
		return movieList;
	}

	/**
	 * Gets the movie by theatre.
	 *
	 * @param theatreId
	 *            the theatre id
	 * @return the movie by theatre
	 */
	@RequestMapping(value = "/getMovies/{theatreId}", method = RequestMethod.GET)
	public @ResponseBody List<Movie> getMovieByTheatre(@PathVariable("theatreId") String theatreId) {
		List<Movie> movieList = movieServiceImpl.getMoviesByTheatre(theatreId);
		return movieList;

	}

	/**
	 * Gets the password.
	 *
	 * @param movieTheatreDTO
	 *            the movie theatre DTO
	 * @return the password
	 */
	@RequestMapping(value = "/getShowtime", method = RequestMethod.POST)
	public @ResponseBody List<String> getShowTime(@RequestBody MovieTheatreDTO movieTheatreDTO) {
		List<String> timeList = movieServiceImpl.getShowTime(movieTheatreDTO);
		// ResultDTO rs = new ResultDTO();
		// rs.setResult(time);
		return timeList;
		// return new ResponseEntity<>(new Gson().toJson(rs), HttpStatus.OK);
	}
	
	
}
