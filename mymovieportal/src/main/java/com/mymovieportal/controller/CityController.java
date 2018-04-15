package com.mymovieportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieportal.dao.CityDAO;
import com.mymovieportal.model.City;
import com.mymovieportal.service.CityService;

// TODO: Auto-generated Javadoc
/**
 * The Class CityController.
 */
@RestController
@RequestMapping("/mymovieportal/city")
public class CityController {

    /** The city service. */
    @Autowired
    CityService cityService;

    /** The city dao. */
    @Autowired
    CityDAO cityDao;

    /**
     * Gets the.
     *
     * @param cityId the city id
     * @return the response entity
     */
    @RequestMapping(value = "/getCity/{cityId}", method = RequestMethod.GET)
    public ResponseEntity<City> get(@PathVariable("cityId") String cityId) {
        City city = cityService.getCity(cityId);
        return ResponseEntity.ok().body(city);
    }

    /**
     * Gets the cities.
     *
     * @return the cities
     */
    @RequestMapping(value = "/getCities", method = RequestMethod.GET)
    public @ResponseBody List<City> getCities() {
        List<City> cityList = cityService.getCities();
        return cityList;
    }

    /**
     * Gets the city name only.
     *
     * @param cityId the city id
     * @return the city name only
     */
    // method used for getting city name only
    @RequestMapping(value = "/getCityNameOnly/{cityId}", method = RequestMethod.GET)
    public String getCityNameOnly(@PathVariable("cityId") String cityId) {
        return cityDao.getCityNameOnly(cityId);
    }
}
