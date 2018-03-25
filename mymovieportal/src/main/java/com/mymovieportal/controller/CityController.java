package com.mymovieportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mymovieportal.model.City;
import com.mymovieportal.service.CityService;

@RestController
@RequestMapping("/mymovieportal/city")
public class CityController {
    @Autowired
    CityService cityService;

    @RequestMapping(value = "/getCity/{cityId}", method = RequestMethod.GET)
    public ResponseEntity<City> get(@PathVariable("cityId") String cityId) {
        City city = cityService.getCity(cityId);
        if (city != null) {
            return ResponseEntity.ok().body(city);
        } else {
            City city1 = new City();
            return ResponseEntity.ok().body(city1);
        }

    }

    @RequestMapping(value = "/getCities", method = RequestMethod.GET)
    public @ResponseBody List<City> getCities() {
        List<City> cityList = cityService.getCities();
        return cityList;
    }
}