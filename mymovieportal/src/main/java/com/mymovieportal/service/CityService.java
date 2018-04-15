package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.dto.CityDTO;
import com.mymovieportal.model.City;

// TODO: Auto-generated Javadoc
/**
 * The Interface CityService.
 */
public interface CityService {

    /**
     * Gets the city.
     *
     * @param cityId the city id
     * @return the city
     */
    City getCity(String cityId);

    /**
     * Gets the cities.
     *
     * @return the cities
     */
    List<City> getCities();

    /**
     * Gets the city name only.
     *
     * @param cityId the city id
     * @return the city name only
     */
    String getCityNameOnly(String cityId);

    City deleteCity(CityDTO cityDTO);

    City insertCity(CityDTO cityDTO);
}
