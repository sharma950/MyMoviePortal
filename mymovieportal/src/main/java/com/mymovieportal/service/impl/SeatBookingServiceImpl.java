package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.SeatBookingDAO;
import com.mymovieportal.model.SeatBooking;
import com.mymovieportal.service.SeatBookingService;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatBookingServiceImpl.
 */
@Service
public class SeatBookingServiceImpl implements SeatBookingService {

	/** The seat booking dao. */
	@Autowired
	SeatBookingDAO seatBookingDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mymovieportal.service.SeatBookingService#getSeatName(com.mymovieportal.
	 * model.SeatBooking)
	 */
	@Override
	@Transactional
	public List<String> getSeatName(SeatBooking seatbooking) {
		// TODO Auto-generated method stub
		return seatBookingDao.getSeatName(seatbooking);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mymovieportal.service.SeatBookingService#setSeatName(com.mymovieportal.
	 * model.SeatBooking)
	 */
	@Override
	public String setSeatName(SeatBooking seatbooking) {
		// TODO Auto-generated method stub
		return null;
	}

}
