package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.dto.MovieDTO;
import com.mymovieportal.dto.MovieTheatreDTO;
import com.mymovieportal.model.Movie;

// TODO: Auto-generated Javadoc
/**
 * The Interface MovieService.
 */
public interface MovieService {

    /**
     * Gets the movies.
     *
     * @return the movies
     */
    List<Movie> getMovies();

    /**
     * Gets the movie name only.
     *
     * @param movieId the movie id
     * @return the movie name only
     */
    String getMovieNameOnly(String movieId);

    /**
     * Gets the show time.
     *
     * @param movieTheatreDTO the movie theatre DTO
     * @return the show time
     */
    List<String> getShowTime(MovieTheatreDTO movieTheatreDTO);

    /**
     * Gets the movies by theatre.
     *
     * @param theatreId the theatre id
     * @return the movies by theatre
     */
    List<Movie> getMoviesByTheatre(String theatreId);

    /**
     * Gets the movie.
     *
     * @param movieId the movie id
     * @return the movie
     */
    Movie getMovie(String movieId);

    /**
     * Gets the discount.
     *
     * @param movieTheatreDTO the movie theatre DTO
     * @return the discount
     */
    int getDiscount(MovieTheatreDTO movieTheatreDTO);

    Movie deleteMovie(MovieDTO movieDTO);

    Movie insertMovie(MovieDTO movieDTO);

}
