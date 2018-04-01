package com.mymovieportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * @param seatBooking
	 *            the seat booking
	 * @return the seat name
	 */
	@RequestMapping(value = "/getSeatName", method = RequestMethod.POST)
	public @ResponseBody List<String> getSeatName(@RequestBody SeatBooking seatBooking) {

		// ModelMapper modelMapper = new ModelMapper();
		// SeatBooking seatBooking = modelMapper.map(seatBookingDTO, SeatBooking.class);
		List<String> seatsName = seatBookingService.getSeatName(seatBooking);
		return seatsName;
		/*
		 * Gson gson = new
		 * GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create(); return
		 * new ResponseEntity<>(gson.toJson(userDTO), HttpStatus.CREATED);
		 */

	}
}
