package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.model.City;

// TODO: Auto-generated Javadoc
/**
 * The Interface CityService.
 */
public interface CityService {

	/**
	 * Gets the city.
	 *
	 * @param cityId
	 *            the city id
	 * @return the city
	 */
	City getCity(String cityId);

	/**
	 * Gets the cities.
	 *
	 * @return the cities
	 */
	List<City> getCities();
}
