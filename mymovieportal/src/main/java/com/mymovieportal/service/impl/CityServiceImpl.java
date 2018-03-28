package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.CityDAO;
import com.mymovieportal.model.City;
import com.mymovieportal.repository.CityRepository;
import com.mymovieportal.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityRepository cityRepository;

    @Override
    @Transactional
    public City getCity(String cityId) {
        // TODO Auto-generated method stub
    	City city = cityRepository.findByCityId(cityId);
        return city;
    }

    @Override
    @Transactional
    public List<City> getCities() {
        // TODO Auto-generated method stub
    	List<City> cityList = cityRepository.findAll();
        return cityList;
    }

}
