package com.mymovieportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mymovieportal.model.City;

public interface CityRepository extends JpaRepository<City, Integer>{
	City findByCityId(String cityId);
}
