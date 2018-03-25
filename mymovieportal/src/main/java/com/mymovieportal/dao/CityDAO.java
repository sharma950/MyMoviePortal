package com.mymovieportal.dao;

import java.util.List;

import com.mymovieportal.model.City;

public interface CityDAO {

    City getCity(String cityId);

    List<City> getCities();
}
