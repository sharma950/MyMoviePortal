package com.mymovieportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mymovieportal.dto.CityDTO;
import com.mymovieportal.dto.MovieDTO;
import com.mymovieportal.dto.TheatreDTO;
import com.mymovieportal.exceptions.CityException;
import com.mymovieportal.model.City;
import com.mymovieportal.model.Movie;
import com.mymovieportal.model.Theatre;
import com.mymovieportal.service.CityService;
import com.mymovieportal.service.MovieService;
import com.mymovieportal.service.TheatreService;

@RestController
@RequestMapping("/mymovieportal/admin")
public class AdminController {

	@Autowired
	CityService cityService;

	@Autowired
	TheatreService theatreService;

	@Autowired
	MovieService movieService;

	@RequestMapping(value = "/insertCity", method = RequestMethod.POST)
	public ResponseEntity<String> insertCity(@RequestBody CityDTO cityDTO) throws CityException {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();

		if (cityDTO == null || cityDTO.getCityName() == null || "".equals(cityDTO.getCityName())) {
			return new ResponseEntity<>(gson.toJson(new CityException("receving City Object is null")),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}

		City city = cityService.insertCity(cityDTO);
		if (city == null) {
			return new ResponseEntity<>(gson.toJson(new CityException("City Object is null")),
					HttpStatus.INTERNAL_SERVER_ERROR);

		}
		return new ResponseEntity<>(gson.toJson(city), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/deleteCity", method = RequestMethod.POST)
	public ResponseEntity<String> deleteCity(@RequestBody CityDTO cityDTO) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		if (cityDTO.getCityName() == null || "".equals(cityDTO.getCityName())) {
			return new ResponseEntity<>(gson.toJson(cityDTO), HttpStatus.NOT_FOUND);
		}
		City city = cityService.deleteCity(cityDTO);

		return new ResponseEntity<>(gson.toJson(city), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/insertTheatre", method = RequestMethod.POST)
	public ResponseEntity<String> insertTheatre(@RequestBody TheatreDTO theatreDTO) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		if (theatreDTO.getTheatreName() == null || "".equals(theatreDTO.getTheatreName())) {
			return new ResponseEntity<>(gson.toJson(theatreDTO), HttpStatus.NOT_FOUND);
		}
		Theatre theatre = theatreService.insertTheatre(theatreDTO);
		return new ResponseEntity<>(gson.toJson(theatre), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/deleteTheatre", method = RequestMethod.POST)
	public ResponseEntity<String> deleteTheatre(@RequestBody TheatreDTO theatreDTO) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		if (theatreDTO.getTheatreName() == null || "".equals(theatreDTO.getTheatreName())) {
			return new ResponseEntity<>(gson.toJson(theatreDTO), HttpStatus.NOT_FOUND);
		}
		Theatre theatre = theatreService.deleteTheatre(theatreDTO);

		return new ResponseEntity<>(gson.toJson(theatre), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/insertMovie", method = RequestMethod.POST)
	public ResponseEntity<String> insertMovie(@RequestBody MovieDTO movieDTO) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		if (movieDTO.getMovieName() == null || "".equals(movieDTO.getMovieName())) {
			return new ResponseEntity<>(gson.toJson(movieDTO), HttpStatus.NOT_FOUND);
		}
		Movie movie = movieService.insertMovie(movieDTO);
		return new ResponseEntity<>(gson.toJson(movie), HttpStatus.CREATED);
	}

	@RequestMapping(value = "/deleteMovie", method = RequestMethod.POST)
	public ResponseEntity<String> deleteMovie(@RequestBody MovieDTO movieDTO) {

		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").create();
		if (movieDTO.getMovieName() == null || "".equals(movieDTO.getMovieName())) {
			return new ResponseEntity<>(gson.toJson(movieDTO), HttpStatus.NOT_FOUND);
		}
		Movie movie = movieService.deleteMovie(movieDTO);

		return new ResponseEntity<>(gson.toJson(movie), HttpStatus.CREATED);
	}

}
