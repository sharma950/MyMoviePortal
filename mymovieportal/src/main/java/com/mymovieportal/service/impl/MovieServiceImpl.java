package com.mymovieportal.service.impl;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dto.MovieDTO;
import com.mymovieportal.dto.MovieTheatreDTO;
import com.mymovieportal.model.Movie;
import com.mymovieportal.repository.MovieRepository;
import com.mymovieportal.repository.ShowtimeRepository;
import com.mymovieportal.service.MovieService;

// TODO: Auto-generated Javadoc
/**
 * The Class MovieServiceImpl.
 */
@Service
public class MovieServiceImpl implements MovieService {

    /** The movie repository. */
    @Autowired
    MovieRepository movieRepository;

    /** The showtime repository. */
    @Autowired
    ShowtimeRepository showtimeRepository;

    /**
     * Gets the movies.
     *
     * @return the movies
     */
    @Override
    @Transactional
    public List<Movie> getMovies() {
        // TODO Auto-generated method stub
        return movieRepository.getMovies();
    }

    /**
     * Gets the movie.
     *
     * @param movieId the movie id
     * @return the movie
     */
    @Override
    @Transactional
    public Movie getMovie(String movieId) {
        return movieRepository.findByMovieId(movieId);
    }

    /**
     * Gets the movies by theatre.
     *
     * @param theatreId the theatre id
     * @return the movies by theatre
     */
    @Override
    @Transactional
    public List<Movie> getMoviesByTheatre(String theatreId) {
        // TODO Auto-generated method stub
        return movieRepository.getMoviesByTheatre(theatreId);
    }

    /**
     * Gets the show time.
     *
     * @param movieTheatreDTO the movie theatre DTO
     * @return the show time
     */
    @Override
    @Transactional
    public List<String> getShowTime(MovieTheatreDTO movieTheatreDTO) {
        String movieId = movieTheatreDTO.getMtMovieId();
        String theatreId = movieTheatreDTO.getMtTheatreId();
        List<String> str = showtimeRepository.getShowTime(movieId, theatreId);

        for (int i = 0; i < str.size(); i++) {
            String[] splited = str.get(i).split("\\s+");
            str.remove(str.get(i));
            str.add(i, splited[1]);

        }

        Object[] arr = str.toArray();
        String[] stringArray = Arrays.copyOf(arr, arr.length, String[].class);
        Arrays.sort(stringArray);
        str = Arrays.asList(stringArray);
        return str;

    }

    @Override
    @Transactional
    public String getMovieNameOnly(String movieId) {
        return movieRepository.getMovieNameOnly(movieId);
    }

    @Override
    @Transactional
    public int getDiscount(MovieTheatreDTO movieTheatreDTO) {
        String movieId = movieTheatreDTO.getMtMovieId();
        String theatreId = movieTheatreDTO.getMtTheatreId();
        List<Integer> discount = movieRepository.getDiscount(movieId, theatreId);
        return discount.get(0);

    }

    @Override
    @Transactional
    public Movie insertMovie(MovieDTO movieDTO) {
        // TODO Auto-generated method stub
        List<String> movieIds = movieRepository.getMovieIds();
        String id = movieIds.get(movieIds.size() - 1);
        String ch = "m";
        id = id.substring(1);
        int movieId = Integer.parseInt(id);
        if (movieId < 9) {
            ch += "0";
        }
        movieId++;

        Movie movie = new Movie();
        movie.setMovieName(movieDTO.getMovieName());
        movie.setMovieId(ch + movieId);
        movie.setMovieStatus("active");
        movie.setMoviePrice("250");
        Movie response = movieRepository.save(movie);
        return response;

    }

    @Override
    @Transactional
    public Movie deleteMovie(MovieDTO movieDTO) {
        // TODO Auto-generated method stub

        Movie movie = movieRepository.findByMovieNameAndMovieStatus(movieDTO.getMovieName(), "active");
        if (movie == null) {
            return movie;
        }
        movie.setMovieName(movie.getMovieName());
        movie.setMovieStatus("inactive");
        movie.setMovieId(movie.getMovieId());
        Movie response = movieRepository.save(movie);
        return response;

    }
}
