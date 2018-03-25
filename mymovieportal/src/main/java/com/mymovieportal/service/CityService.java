package com.mymovieportal.service;

import java.util.List;

import com.mymovieportal.model.City;

public interface CityService {

    City getCity(String cityId);

    List<City> getCities();
}
