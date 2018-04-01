package com.mymovieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatBooking.
 */
@Entity
@Table(name = "seatbooking")
public class SeatBooking {

	/** The seat booking id. */
	@Id
	@Column(name = "seatbooking_id")
	private String seatBookingId;

	/** The sb city id. */
	@Column(name = "sb_city_id")
	private String sbCityId;

	/** The sb theatre id. */
	@Column(name = "sb_theatre_id")
	private String sbTheatreId;

	/** The sb movie id. */
	@Column(name = "sb_movie_id")
	private String sbMovieId;

	/** The sb showtime id. */
	@Column(name = "sb_showtime_id")
	private String sbShowtimeId;

	/** The seat name. */
	@Column(name = "seat_name")
	private String seatName;

	/**
	 * Instantiates a new seat booking.
	 */
	public SeatBooking() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the seat booking id.
	 *
	 * @return the seat booking id
	 */
	public String getSeatBookingId() {
		return seatBookingId;
	}

	/**
	 * Sets the seat booking id.
	 *
	 * @param seatBookingId
	 *            the new seat booking id
	 */
	public void setSeatBookingId(String seatBookingId) {
		this.seatBookingId = seatBookingId;
	}

	/**
	 * Gets the sb city id.
	 *
	 * @return the sb city id
	 */
	public String getSbCityId() {
		return sbCityId;
	}

	/**
	 * Sets the sb city id.
	 *
	 * @param sbCityId
	 *            the new sb city id
	 */
	public void setSbCityId(String sbCityId) {
		this.sbCityId = sbCityId;
	}

	/**
	 * Gets the sb theatre id.
	 *
	 * @return the sb theatre id
	 */
	public String getSbTheatreId() {
		return sbTheatreId;
	}

	/**
	 * Sets the sb theatre id.
	 *
	 * @param sbTheatreId
	 *            the new sb theatre id
	 */
	public void setSbTheatreId(String sbTheatreId) {
		this.sbTheatreId = sbTheatreId;
	}

	/**
	 * Gets the sb movie id.
	 *
	 * @return the sb movie id
	 */
	public String getSbMovieId() {
		return sbMovieId;
	}

	/**
	 * Sets the sb movie id.
	 *
	 * @param sbMovieId
	 *            the new sb movie id
	 */
	public void setSbMovieId(String sbMovieId) {
		this.sbMovieId = sbMovieId;
	}

	/**
	 * Gets the sb showtime id.
	 *
	 * @return the sb showtime id
	 */
	public String getSbShowtimeId() {
		return sbShowtimeId;
	}

	/**
	 * Sets the sb showtime id.
	 *
	 * @param sbShowtimeId
	 *            the new sb showtime id
	 */
	public void setSbShowtimeId(String sbShowtimeId) {
		this.sbShowtimeId = sbShowtimeId;
	}

	/**
	 * Gets the seat name.
	 *
	 * @return the seat name
	 */
	public String getSeatName() {
		return seatName;
	}

	/**
	 * Sets the seat name.
	 *
	 * @param seatName
	 *            the new seat name
	 */
	public void setSeatName(String seatName) {
		this.seatName = seatName;
	}

}
