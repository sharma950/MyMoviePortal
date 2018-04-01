package com.mymovieportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieportal.model.Theatre;
import com.mymovieportal.service.impl.TheatreServiceImpl;

// TODO: Auto-generated Javadoc
/**
 * The Class TheatreController.
 */
@RestController
@RequestMapping("/mymovieportal/theatre")
public class TheatreController {

	/** The theatre service impl. */
	@Autowired
	TheatreServiceImpl theatreServiceImpl;

	/**
	 * Gets the.
	 *
	 * @param theatreId
	 *            the theatre id
	 * @return the response entity
	 */
	@RequestMapping(value = "/getTheatre/{theatreId}", method = RequestMethod.GET)
	public ResponseEntity<Theatre> get(@PathVariable("theatreId") String theatreId) {
		Theatre theatre = theatreServiceImpl.getTheatre(theatreId);
		if (theatre != null) {
			return ResponseEntity.ok().body(theatre);
		} else {
			Theatre theatre1 = new Theatre();
			return ResponseEntity.ok().body(theatre1);
		}

	}

	/**
	 * Gets the theatres.
	 *
	 * @return the theatres
	 */
	@RequestMapping(value = "/getTheatres", method = RequestMethod.GET)
	public @ResponseBody List<Theatre> getTheatres() {

		List<Theatre> theatreList = theatreServiceImpl.getTheatres();
		return theatreList;
	}

	/**
	 * Gets the theatres by city.
	 *
	 * @param cityId
	 *            the city id
	 * @return the theatres by city
	 */
	@RequestMapping(value = "/getTheatres/{cityId}", method = RequestMethod.GET)
	public @ResponseBody List<Theatre> getTheatresByCity(@PathVariable("cityId") String cityId) {

		List<Theatre> theatreList = theatreServiceImpl.getTheatresByCity(cityId);
		return theatreList;
	}
}
