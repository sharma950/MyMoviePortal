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
    @Query("from Movie where movieStatus = 'active' ")
    List<Movie> getMovies();

    /**
     * Gets the movies by theatre.
     *
     * @param theatreId the theatre id
     * @return the movies by theatre
     */
    @Query("from Movie where movieStatus = 'active' and movieId in (select mtMovieId from MovieTheatre where mtTheatreId=:theatreId)")
    List<Movie> getMoviesByTheatre(@Param("theatreId") String theatreId);

    /**
     * Find by movie id.
     *
     * @param movieId the movie id
     * @return the movie
     */
    Movie findByMovieId(String movieId);

    /**
     * Gets the movie name only.
     *
     * @param movieid the movieid
     * @return the movie name only
     */
    @Query("select movieName from Movie where movieId=:movieid")
    String getMovieNameOnly(@Param("movieid") String movieid);

    /**
     * Gets the discount.
     *
     * @param movieId the movie id
     * @param theatreId the theatre id
     * @return the discount
     */
    @Query("select discount from MovieTheatre where mtMovieId=:movieId and mtTheatreId=:theatreId")
    List<Integer> getDiscount(@Param("movieId") String movieId,@Param("theatreId") String theatreId);

    @Query("select movieId from Movie")
    List<String> getMovieIds();

    Movie findByMovieNameAndMovieStatus(String movieName, String status);
}
