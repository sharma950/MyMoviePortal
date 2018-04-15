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

import com.mymovieportal.model.SeatBooking;
import com.mymovieportal.service.SeatBookingService;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatBookingController.
 */
@RestController
@RequestMapping("/mymovieportal/seatbooking")
public class SeatBookingController {

    /** The seat booking service. */
    @Autowired
    SeatBookingService seatBookingService;

    /**
     * Gets the seat name.
     *
     * @param seatBooking the seat booking
     * @return the seat name
     */
    @RequestMapping(value = "/getSeatName", method = RequestMethod.POST)
    public @ResponseBody List<String> getSeatName(@RequestBody SeatBooking seatBooking) {
        List<String> seatsName = seatBookingService.getSeatName(seatBooking);
        return seatsName;
    }

    /**
     * Sets the seat name.
     *
     * @param seatBooking the seat booking
     * @return the response entity
     */
    @RequestMapping(value = "/setSeatName", method = RequestMethod.POST)
    public ResponseEntity<SeatBooking[]> setSeatName(@RequestBody SeatBooking[] seatBooking) {
        boolean result = seatBookingService.setSeatName(seatBooking);
        return ResponseEntity.ok().body(seatBooking);

    }

    /**
     * Gets the user history.
     *
     * @param sbUserId the sb user id
     * @return the user history
     */
    @RequestMapping(value = "/getUserHistory/{sbUserId}", method = RequestMethod.GET)
    public ResponseEntity<SeatBooking[]> getUserHistory(@PathVariable("sbUserId") long sbUserId) {
        SeatBooking[] seatBooking = seatBookingService.findBySbUserId(sbUserId);
        return ResponseEntity.ok().body(seatBooking);

    }

    /**
     * Cancel ticket.
     *
     * @param sbUserId the sb user id
     * @return the response entity
     */
    @RequestMapping(value = "/cancelTicket/{sbUserId}", method = RequestMethod.GET)
    public ResponseEntity<SeatBooking[]> cancelTicket(@PathVariable("sbUserId") long sbUserId) {
        SeatBooking[] seatBooking = seatBookingService.cancelTicket(sbUserId);
        return ResponseEntity.ok().body(seatBooking);

    }

    /**
     * Go to cancel ticket.
     *
     * @param seatBookingId the seat booking id
     * @return the response entity
     */
    @RequestMapping(value = "/goToCancelTicket/{seatBookingId}", method = RequestMethod.GET)
    public ResponseEntity<Integer> goToCancelTicket(@PathVariable("seatBookingId") long seatBookingId) {
        int seatBooking = seatBookingService.goToCancelTicket(seatBookingId);
        return ResponseEntity.ok().body(seatBooking);

    }
}
