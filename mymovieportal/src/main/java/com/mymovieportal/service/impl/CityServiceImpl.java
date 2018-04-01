package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.CityDAO;
import com.mymovieportal.model.City;
import com.mymovieportal.service.CityService;

// TODO: Auto-generated Javadoc
/**
 * The Class CityServiceImpl.
 */
@Service
public class CityServiceImpl implements CityService {

	/** The city dao. */
	@Autowired
	CityDAO cityDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mymovieportal.service.CityService#getCity(java.lang.String)
	 */
	@Override
	@Transactional
	public City getCity(String cityId) {
		// TODO Auto-generated method stub
		return cityDao.getCity(cityId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.mymovieportal.service.CityService#getCities()
	 */
	@Override
	@Transactional
	public List<City> getCities() {
		// TODO Auto-generated method stub
		return cityDao.getCities();
	}

}
