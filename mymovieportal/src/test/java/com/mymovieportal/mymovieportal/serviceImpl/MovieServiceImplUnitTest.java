package com.mymovieportal.mymovieportal.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mymovieportal.dto.MovieTheatreDTO;
import com.mymovieportal.model.Movie;
import com.mymovieportal.repository.MovieRepository;
import com.mymovieportal.repository.ShowtimeRepository;
import com.mymovieportal.service.MovieService;
import com.mymovieportal.service.impl.MovieServiceImpl;

public class MovieServiceImplUnitTest {

    @InjectMocks
    MovieService movieService = new MovieServiceImpl();

    @Mock
    MovieRepository movieRepository;

    @Mock
    ShowtimeRepository showtimeRepository;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMovies() {
        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie());
        movieList.add(new Movie());

        when(movieRepository.findAll()).thenReturn(movieList);

        List<Movie> movies = movieService.getMovies();

        assertNotNull(movies);
    }

    @Test
    public void testGetMovie() {
        Movie movie = new Movie();
        movie.setMovieId("m01");
        movie.setMovieName("Dhoom");

        when(movieRepository.findByMovieId(anyString())).thenReturn(movie);

        Movie movie2 = movieService.getMovie("m01");

        assertEquals(movie2.getMovieId(), "m01");

    }

    @Test
    public void testGetCityInvalid() {

        when(movieRepository.findByMovieId(anyString())).thenReturn(null);
        Movie movie2 = movieService.getMovie("m01");
        assertNull(movie2);
    }

    @Test
    public void testGetMoviesByTheatre() {
        List<Movie> movieList = new ArrayList<>();

        movieList.add(new Movie());
        movieList.add(new Movie());

        when(movieRepository.getMoviesByTheatre(anyString())).thenReturn(movieList);
        List<Movie> movies = movieService.getMoviesByTheatre("t01");

        assertNotNull(movies);
    }

    @Test
    public void testGetMoviesByTheatreInvalid() {
        List<Movie> movieList = new ArrayList<>();

        when(movieRepository.getMoviesByTheatre(anyString())).thenReturn(movieList);
        List<Movie> movies = movieService.getMoviesByTheatre("00");

        assertTrue(movies.size() == 0);
    }

    @Test
    public void testGetShowTime() {
        List<String> timeList = new ArrayList<>();
        timeList.add("2018-04-14 19:08:12");
        timeList.add("2018-04-18 13:01:42");

        MovieTheatreDTO movieTheatreDTO = new MovieTheatreDTO();
        movieTheatreDTO.setMtMovieId("m01");
        movieTheatreDTO.setMtTheatreId("t01");

        when(showtimeRepository.getShowTime(anyString(), anyString())).thenReturn(timeList);

        List<String> times = movieService.getShowTime(movieTheatreDTO);

        assertNotNull(times);

    }

    @Test
    public void testGetShowTimeInvalid() {
        List<String> timeList = new ArrayList<>();

        MovieTheatreDTO movieTheatreDTO = new MovieTheatreDTO();
        movieTheatreDTO.setMtMovieId("00");
        movieTheatreDTO.setMtTheatreId("00");

        when(showtimeRepository.getShowTime(anyString(), anyString())).thenReturn(timeList);

        List<String> times = movieService.getShowTime(movieTheatreDTO);

        assertTrue(times.size() == 0);
    }

    @Test
    public void testMovieNameOnly() {

        String movieName = "Dhoom";
        when(movieRepository.getMovieNameOnly(anyString())).thenReturn(movieName);
        String movieN = movieService.getMovieNameOnly("m01");
        assertSame(movieName, movieN);
    }

    @Test
    public void testMovieNameOnlyInvalid() {

        String movieName = null;
        when(movieRepository.getMovieNameOnly(anyString())).thenReturn(movieName);
        String movieN = movieService.getMovieNameOnly("00");
        assertNull(movieName, movieN);
    }

    @Test
    public void testGetDiscount() {
        List<Integer> discountList = new ArrayList<>();
        discountList.add(10);
        discountList.add(15);

        MovieTheatreDTO movieTheatreDTO = new MovieTheatreDTO();
        movieTheatreDTO.setMtMovieId("m01");
        movieTheatreDTO.setMtTheatreId("t01");

        when(movieRepository.getDiscount(anyString(), anyString())).thenReturn(discountList);

        int list = movieService.getDiscount(movieTheatreDTO);

        assertNotNull(list);

    }

    @Test
    public void testGetDiscountInvalid() {
        List<Integer> discountList = new ArrayList<>();
        discountList.add(0);

        MovieTheatreDTO movieTheatreDTO = new MovieTheatreDTO();
        movieTheatreDTO.setMtMovieId("00");
        movieTheatreDTO.setMtTheatreId("00");

        when(movieRepository.getDiscount(anyString(), anyString())).thenReturn(discountList);

        int list = movieService.getDiscount(movieTheatreDTO);

        assertTrue(list == 0);

    }
}
