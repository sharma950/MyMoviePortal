package com.mymovieportal.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.SeatBookingDAO;
import com.mymovieportal.model.SeatBooking;
import com.mymovieportal.repository.MovieRepository;
import com.mymovieportal.repository.SeatBookingRepository;
import com.mymovieportal.repository.TheatreRepository;
import com.mymovieportal.service.CityService;
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

    /** The seat booking repository. */
    @Autowired
    SeatBookingRepository seatBookingRepository;

    /** The city service. */
    @Autowired
    CityService cityService;

    /** The movie repository. */
    @Autowired
    MovieRepository movieRepository;

    /** The theatre repository. */
    @Autowired
    TheatreRepository theatreRepository;

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.service.SeatBookingService#getSeatName(com.mymovieportal.model.SeatBooking)
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
     * @see com.mymovieportal.service.SeatBookingService#setSeatName(com.mymovieportal.model.SeatBooking)
     */
    @Override
    @Transactional
    public boolean setSeatName(SeatBooking[] seatbooking) {
        // TODO Auto-generated method stub
        return seatBookingDao.setSeatName(seatbooking);
    }

    /*
     * (non-Javadoc)
     *
     * @see com.mymovieportal.repository.SeatBookingRepository#findBySbUserId(long)
     */

    /**
     * Find by sb user id.
     *
     * @param sbUserId the sb user id
     * @return the seat booking DT o[]
     */
    @Override
    @Transactional
    public SeatBooking[] findBySbUserId(long sbUserId) {

        SeatBooking[] seatBooking = seatBookingRepository.findBySbUserId(sbUserId);
        for (SeatBooking seat : seatBooking) {

            seat.setSbCityName(cityService.getCityNameOnly(seat.getSbCityId()));
            seat.setSbMovieName(movieRepository.getMovieNameOnly(seat.getSbMovieId()));
            seat.setSbTheatreName(theatreRepository.getTheatreNameOnly(seat.getSbTheatreId()));
        }

        return seatBooking;

    }

    /* (non-Javadoc)
     * @see com.mymovieportal.service.SeatBookingService#cancelTicket(long)
     */
    @Override
    @Transactional
    public SeatBooking[] cancelTicket(long sbUserId) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        DateFormat dateFormat1 = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String date1 = dateFormat.format(date);
        String time = dateFormat1.format(date);
        SeatBooking[] seatBooking = seatBookingRepository.cancelTicket(sbUserId, date1, time);

        for (SeatBooking seat : seatBooking) {

            seat.setSbCityName(cityService.getCityNameOnly(seat.getSbCityId()));
            seat.setSbMovieName(movieRepository.getMovieNameOnly(seat.getSbMovieId()));
            seat.setSbTheatreName(theatreRepository.getTheatreNameOnly(seat.getSbTheatreId()));
        }
        return seatBooking;
    }

    /* (non-Javadoc)
     * @see com.mymovieportal.service.SeatBookingService#goToCancelTicket(long)
     */
    @Override
    @Transactional
    public int goToCancelTicket(long seatBookingId) {

        return seatBookingRepository.goToCancelTicket(seatBookingId);

    }

    @Override
    public List<String> getSeatNames(long sbUserId, String sbDate, String sbShowTime, String sbTheatreId,
        String sbMovieid) {
        // TODO Auto-generated method stub
        return seatBookingRepository.getSeatNames(sbUserId, sbDate, sbShowTime, sbTheatreId, sbMovieid);
    }


}
