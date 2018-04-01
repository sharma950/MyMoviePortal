package com.mymovieportal.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymovieportal.dao.SeatBookingDAO;
import com.mymovieportal.model.SeatBooking;

// TODO: Auto-generated Javadoc
/**
 * The Class SeatBookingDAOImpl.
 */
@Repository
@Transactional
public class SeatBookingDAOImpl implements SeatBookingDAO {

	/** The session factory. */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mymovieportal.dao.SeatBookingDAO#getSeatName(com.mymovieportal.model.
	 * SeatBooking)
	 */
	@Override
	public List<String> getSeatName(SeatBooking seatbooking) {
		// TODO Auto-generated method stub
		String sbCityId = seatbooking.getSbCityId();
		String sbTheatreId = seatbooking.getSbTheatreId();
		String sbMovieId = seatbooking.getSbMovieId();
		String sbShowId = seatbooking.getSbShowtimeId();
		String myquery = "from SeatBooking where sbCityId=:cityId and sbTheatreId=:theatreId and sbMovieId=:movieId and sbShowtimeId=:showId";
		Query query = getSession().createQuery(myquery);
		query.setParameter("cityId", sbCityId);
		query.setParameter("theatreId", sbTheatreId);
		query.setParameter("movieId", sbMovieId);
		query.setParameter("showId", sbShowId);
		List<SeatBooking> seatList = query.list();
		Iterator<SeatBooking> seatItr = seatList.iterator();
		List<String> seatsName = new ArrayList();
		SeatBooking seat;
		while (seatItr.hasNext()) {
			seat = seatItr.next();
			seatsName.add(seat.getSeatName());
		}
		return seatsName;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.mymovieportal.dao.SeatBookingDAO#setSeatName(com.mymovieportal.model.
	 * SeatBooking)
	 */
	@Override
	public String setSeatName(SeatBooking seatbooking) {
		// TODO Auto-generated method stub
		return null;
	}

}
