package com.mymovieportal.controller;

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
import com.mymovieportal.service.MovieService;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieController.
 */
@RestController
@RequestMapping("/mymovieportal/movie")
public class MovieController {

    /** The movie service impl. */
    @Autowired
    MovieService movieService;

    /**
     * Gets the movies.
     *
     * @return the movies
     */
    @RequestMapping(value = "/getMovies", method = RequestMethod.GET)
    public @ResponseBody List<Movie> getMovies() {

        List<Movie> movieList = movieService.getMovies();
        return movieList;
    }

    /**
     * Gets the movie.
     *
     * @param movieId the movie id
     * @return the movie
     */
    @RequestMapping(value = "/getMovie/{movieId}", method = RequestMethod.GET)
    public @ResponseBody Movie getMovie(@PathVariable("movieId") String movieId) {

        Movie movie = movieService.getMovie(movieId);
        return movie;
    }

    /**
     * Gets the movie by theatre.
     *
     * @param theatreId the theatre id
     * @return the movie by theatre
     */
    @RequestMapping(value = "/getMovies/{theatreId}", method = RequestMethod.GET)
    public @ResponseBody List<Movie> getMovieByTheatre(@PathVariable("theatreId") String theatreId) {
        List<Movie> movieList = movieService.getMoviesByTheatre(theatreId);
        return movieList;

    }

    /**
     * Gets the password.
     *
     * @param movieTheatreDTO the movie theatre DTO
     * @return the show time
     */
    @RequestMapping(value = "/getShowtime", method = RequestMethod.POST)
    public @ResponseBody List<String> getShowTime(@RequestBody MovieTheatreDTO movieTheatreDTO) {
        List<String> timeList = movieService.getShowTime(movieTheatreDTO);
        return timeList;

    }

    /**
     * Gets the discount.
     *
     * @param movieTheatreDTO the movie theatre DTO
     * @return the discount
     */
    @RequestMapping(value = "/getDiscount", method = RequestMethod.POST)
    public ResponseEntity<Integer> getDiscount(@RequestBody MovieTheatreDTO movieTheatreDTO) {
        int discount = movieService.getDiscount(movieTheatreDTO);
        return ResponseEntity.ok().body(discount);

    }
}
