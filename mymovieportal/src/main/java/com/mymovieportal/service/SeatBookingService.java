package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.model.SeatBooking;

// TODO: Auto-generated Javadoc
/**
 * The Interface SeatBookingService.
 */
public interface SeatBookingService {

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
