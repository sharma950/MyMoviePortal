package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.CityDAO;
import com.mymovieportal.model.City;
import com.mymovieportal.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityDAO cityDao;

    @Override
    @Transactional
    public City getCity(String cityId) {
        // TODO Auto-generated method stub
        return cityDao.getCity(cityId);
    }

    @Override
    @Transactional
    public List<City> getCities() {
        // TODO Auto-generated method stub
        return cityDao.getCities();
    }

}
