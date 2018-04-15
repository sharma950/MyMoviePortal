package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class Movie.
 */
@Entity
@Table(name = "movie")
public class Movie {

    /** The movie id. */
    @Id
    @Column(name = "movie_id")
    private String movieId;

    /** The movie name. */
    @Column(name = "movie_name")
    private String movieName;

    /** The movie price. */
    @Column(name = "movie_price")
    private String moviePrice;

    @Column(name = "movie_status")
    private String movieStatus;

    /**
     * Instantiates a new movie.
     */
    public Movie() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * Gets the movie id.
     *
     * @return the movie id
     */
    public String getMovieId() {
        return movieId;
    }

    /**
     * Sets the movie id.
     *
     * @param movieId the new movie id
     */
    public void setMovieId(String movieId) {
        this.movieId = movieId;
    }

    /**
     * Gets the movie name.
     *
     * @return the movie name
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * Sets the movie name.
     *
     * @param movieName the new movie name
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    /**
     * Gets the movie price.
     *
     * @return the movie price
     */
    public String getMoviePrice() {
        return moviePrice;
    }

    /**
     * Sets the movie price.
     *
     * @param moviePrice the new movie price
     */
    public void setMoviePrice(String moviePrice) {
        this.moviePrice = moviePrice;
    }

    public String getMovieStatus() {
        return movieStatus;
    }

    public void setMovieStatus(String movieStatus) {
        this.movieStatus = movieStatus;
    }

}
