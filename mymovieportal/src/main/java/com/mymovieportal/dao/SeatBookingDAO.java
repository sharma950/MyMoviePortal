package com.mymovieportal.dao;

import java.util.List;

import com.mymovieportal.model.SeatBooking;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeatBookingDAO.
 */
public interface SeatBookingDAO {

	/**
	 * Gets the seat name.
	 *
	 * @param seatbooking
	 *            the seatbooking
	 * @return the seat name
	 */
	List<String> getSeatName(SeatBooking seatbooking);

	/**
	 * Sets the seat name.
	 *
	 * @param seatbooking
	 *            the seatbooking
	 * @return the string
	 */
	String setSeatName(SeatBooking seatbooking);
}
