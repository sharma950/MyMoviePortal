package com.mymovieportal.mymovieportal.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mymovieportal.dao.SeatBookingDAO;
import com.mymovieportal.model.SeatBooking;
import com.mymovieportal.repository.MovieRepository;
import com.mymovieportal.repository.SeatBookingRepository;
import com.mymovieportal.repository.TheatreRepository;
import com.mymovieportal.service.CityService;
import com.mymovieportal.service.SeatBookingService;
import com.mymovieportal.service.impl.SeatBookingServiceImpl;

public class SeatBookingServiceImplUnitTest {

    @InjectMocks
    SeatBookingService seatBookingService = new SeatBookingServiceImpl();

    @Mock
    SeatBookingDAO seatBookingDao;

    @Mock
    SeatBookingRepository seatBookingRepository;

    @Mock
    CityService cityService;

    @Mock
    MovieRepository movieRepository;

    @Mock
    TheatreRepository theatreRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetSeatsName() {
        SeatBooking seatBooking = new SeatBooking();
        seatBooking.setSbCityId("c01");
        seatBooking.setSbCityName("Indore");
        seatBooking.setSbDate("2018-04-19");
        seatBooking.setSbMovieName("Dabang");

        List<String> seatNames = new ArrayList<>();
        seatNames.add("A6");
        seatNames.add("B7");

        when(seatBookingDao.getSeatName(seatBooking)).thenReturn(seatNames);
        seatNames = seatBookingService.getSeatName(seatBooking);
    }

    @Test
    public void testGetSeatsNameInvalid() {
        SeatBooking seatBooking = new SeatBooking();

        List<String> seatNames = new ArrayList<>();

        when(seatBookingDao.getSeatName(seatBooking)).thenReturn(seatNames);
        seatNames = seatBookingService.getSeatName(seatBooking);
        assertEquals(0, seatNames.size());
    }

    @Test
    public void testSetSeatName() {

        SeatBooking seatBooking[] = new SeatBooking[1];
        seatBooking[0] = new SeatBooking();
        seatBooking[0].setSbCityId("c01");
        seatBooking[0].setSbCityName("Indore");
        seatBooking[0].setSbDate("2018-04-19");
        seatBooking[0].setSbMovieName("Dabang");
        seatBooking[0].setSbMovieId("m01");
        seatBooking[0].setSeatName("A1");

        when(seatBookingDao.setSeatName(seatBooking)).thenReturn(true);
        boolean flag = seatBookingService.setSeatName(seatBooking);
        assertTrue(flag);
    }

    @Test
    public void testFindBySbUserId() {

        SeatBooking seatBooking[] = new SeatBooking[1];
        seatBooking[0] = new SeatBooking();
        seatBooking[0].setSbUserId(1L);
        seatBooking[0].setSbCityId("c01");
        seatBooking[0].setSbDate("2018-04-19");
        seatBooking[0].setSbTheatreId("t01");
        seatBooking[0].setSbMovieId("m01");
        seatBooking[0].setSeatName("A1");

        when(seatBookingRepository.findBySbUserId(1L)).thenReturn(seatBooking);

        when(cityService.getCityNameOnly(seatBooking[0].getSbCityId())).thenReturn("Indore");
        when(movieRepository.getMovieNameOnly(seatBooking[0].getSbMovieId())).thenReturn("Badshah");
        when(theatreRepository.getTheatreNameOnly(seatBooking[0].getSbTheatreId())).thenReturn("INOX");

        SeatBooking s[] = seatBookingService.findBySbUserId(1L);

        assertTrue(s[0] != null);

    }

    @Test
    public void testFindBySbUserIdInvalid() {

        SeatBooking seatBooking[] = new SeatBooking[1];
        seatBooking[0] = new SeatBooking();

        when(seatBookingRepository.findBySbUserId(90L)).thenReturn(seatBooking);

        SeatBooking s[] = seatBookingService.findBySbUserId(90L);

        assertTrue(s[0].getSbCityId() == null);

    }

    @Test
    public void testCancelTicket() {
        SeatBooking seatBooking[] = new SeatBooking[1];
        seatBooking[0] = new SeatBooking();
        seatBooking[0].setSeatBookingId(1L);
        seatBooking[0].setSbCityId("c01");
        seatBooking[0].setSbDate("2018-04-19");
        seatBooking[0].setSbTheatreId("t01");
        seatBooking[0].setSbMovieId("m01");
        seatBooking[0].setSeatName("A1");

        when(seatBookingRepository.cancelTicket(anyLong(), anyString(), anyString())).thenReturn(seatBooking);

        when(cityService.getCityNameOnly(seatBooking[0].getSbCityId())).thenReturn("Indore");
        when(movieRepository.getMovieNameOnly(seatBooking[0].getSbMovieId())).thenReturn("Badshah");
        when(theatreRepository.getTheatreNameOnly(seatBooking[0].getSbTheatreId())).thenReturn("INOX");

        SeatBooking s[] = seatBookingService.cancelTicket(1L);

        assertTrue(s[0] != null);

    }

    @Test
    public void testCancelTicketInvalid() {

        SeatBooking seatBooking[] = new SeatBooking[1];

        when(seatBookingRepository.cancelTicket(90L, null, null)).thenReturn(seatBooking);

        when(cityService.getCityNameOnly(null)).thenReturn(null);
        when(movieRepository.getMovieNameOnly(null)).thenReturn(null);
        when(theatreRepository.getTheatreNameOnly(null)).thenReturn(null);

        assertTrue(seatBooking[0] == null);
    }

    @Test
    public void testGoToCancelTicket() {
        SeatBooking seatBooking = new SeatBooking();
        seatBooking.setSeatBookingId(1L);
        seatBooking.setSbCityId("c01");
        seatBooking.setSbDate("2018-04-19");
        seatBooking.setSbTheatreId("t01");
        seatBooking.setSbMovieId("m01");
        seatBooking.setSeatName("A2");

        when(seatBookingRepository.goToCancelTicket(seatBooking.getSeatBookingId())).thenReturn(1);

    }

}
