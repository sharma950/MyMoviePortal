package com.mymovieportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mymovieportal.model.Theatre;

// TODO: Auto-generated Javadoc
/**
 * The Interface TheatreRepository.
 */
public interface TheatreRepository extends JpaRepository<Theatre, Integer> {

	/**
	 * Find by theatre id.
	 *
	 * @param theatreId
	 *            the theatre id
	 * @return the theatre
	 */
	Theatre findByTheatreId(String theatreId);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.data.jpa.repository.JpaRepository#findAll()
	 */
	@Override
	List<Theatre> findAll();

	/**
	 * Gets the theatres by city.
	 *
	 * @param cityId
	 *            the city id
	 * @return the theatres by city
	 */
	@Query("from Theatre where theatreId in(select ctTheatreId from CityTheatre where ctCityId= :cityId)")
	List<Theatre> getTheatresByCity(@Param("cityId") String cityId);
}
