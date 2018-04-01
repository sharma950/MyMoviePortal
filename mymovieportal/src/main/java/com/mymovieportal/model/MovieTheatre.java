package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieTheatre.
 */
@Entity
@Table(name = "movietheatre")
public class MovieTheatre {

	/** The movie theatre id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movietheatre_id")
	private Long movieTheatreId;

	/** The mt movie id. */
	@Column(name = "mt_movie_id")
	private String mtMovieId;

	/** The mt theatre id. */
	@Column(name = "mt_theatre_id")
	private String mtTheatreId;

	/** The mt showtime id. */
	@Column(name = "mt_showtime_id")
	private String mtShowtimeId;

	/**
	 * Instantiates a new movie theatre.
	 */
	public MovieTheatre() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the movie theatre id.
	 *
	 * @return the movie theatre id
	 */
	public Long getMovieTheatreId() {
		return movieTheatreId;
	}

	/**
	 * Sets the movie theatre id.
	 *
	 * @param movieTheatreId
	 *            the new movie theatre id
	 */
	public void setMovieTheatreId(Long movieTheatreId) {
		this.movieTheatreId = movieTheatreId;
	}

	/**
	 * Gets the mt movie id.
	 *
	 * @return the mt movie id
	 */
	public String getMtMovieId() {
		return mtMovieId;
	}

	/**
	 * Sets the mt movie id.
	 *
	 * @param mtMovieId
	 *            the new mt movie id
	 */
	public void setMtMovieId(String mtMovieId) {
		this.mtMovieId = mtMovieId;
	}

	/**
	 * Gets the mt theatre id.
	 *
	 * @return the mt theatre id
	 */
	public String getMtTheatreId() {
		return mtTheatreId;
	}

	/**
	 * Sets the mt theatre id.
	 *
	 * @param mtTheatreId
	 *            the new mt theatre id
	 */
	public void setMtTheatreId(String mtTheatreId) {
		this.mtTheatreId = mtTheatreId;
	}

	/**
	 * Gets the mt showtime id.
	 *
	 * @return the mt showtime id
	 */
	public String getMtShowtimeId() {
		return mtShowtimeId;
	}

	/**
	 * Sets the mt showtime id.
	 *
	 * @param mtShowtimeId
	 *            the new mt showtime id
	 */
	public void setMtShowtimeId(String mtShowtimeId) {
		this.mtShowtimeId = mtShowtimeId;
	}

}
