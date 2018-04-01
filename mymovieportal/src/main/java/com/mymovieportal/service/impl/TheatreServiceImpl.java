package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.model.Theatre;
import com.mymovieportal.repository.TheatreRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class TheatreServiceImpl.
 */
@Service
public class TheatreServiceImpl {

	/** The theatre repository. */
	@Autowired
	TheatreRepository theatreRepository;

	/**
	 * Gets the theatre.
	 *
	 * @param theatreId
	 *            the theatre id
	 * @return the theatre
	 */
	@Transactional
	public Theatre getTheatre(String theatreId) {
		// TODO Auto-generated method stub
		Theatre theatre = theatreRepository.findByTheatreId(theatreId);
		return theatre;
	}

	/**
	 * Gets the theatres.
	 *
	 * @return the theatres
	 */
	@Transactional
	public List<Theatre> getTheatres() {
		// TODO Auto-generated method stub
		return theatreRepository.findAll();
	}

	/**
	 * Gets the theatres by city.
	 *
	 * @param cityId
	 *            the city id
	 * @return the theatres by city
	 */
	@Transactional
	public List<Theatre> getTheatresByCity(String cityId) {
		// TODO Auto-generated method stub
		return theatreRepository.getTheatresByCity(cityId);
	}

}
