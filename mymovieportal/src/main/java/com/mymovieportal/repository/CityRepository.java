package com.mymovieportal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.mymovieportal.model.City;
import com.mymovieportal.model.Movie;

public interface CityRepository extends JpaRepository<City, Integer> {

	@Query("select cityId from City")
	List<String> getCityIds();

	City findByCityNameAndCityStatus(String cityName, String status);
}
