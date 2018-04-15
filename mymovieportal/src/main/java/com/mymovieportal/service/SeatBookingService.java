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
     * @param seatbooking the seatbooking
     * @return the seat name
     */
    List<String> getSeatName(SeatBooking seatbooking);

    /**
     * Sets the seat name.
     *
     * @param seatbooking the seatbooking
     * @return the seat booking
     */
    boolean setSeatName(SeatBooking[] seatbooking);

    /**
     * Find by sb user id.
     *
     * @param sbUserId the sb user id
     * @return the seat booking[]
     */
    SeatBooking[] findBySbUserId(long sbUserId);

    /**
     * Cancel ticket.
     *
     * @param sbUserId the sb user id
     * @return the seat booking[]
     */
    SeatBooking[] cancelTicket(long sbUserId);

    /**
     * Go to cancel ticket.
     *
     * @param seatBookingId the seat booking id
     * @return the int
     */
    int goToCancelTicket(long seatBookingId);

    List<String> getSeatNames(long sbUserId, String sbDate, String sbShowTime, String sbTheatreId, String sbTheatreId2);

}
