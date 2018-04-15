package com.mymovieportal.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mymovieportal.dao.CityDAO;
import com.mymovieportal.dto.CityDTO;
import com.mymovieportal.model.City;
import com.mymovieportal.repository.CityRepository;
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


    @Autowired
    CityRepository cityRepository;

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

    @Override
    public String getCityNameOnly(String cityId) {
        // TODO Auto-generated method stub
        return cityDao.getCityNameOnly(cityId);
    }

    @Override
    @Transactional
    public City insertCity(CityDTO cityDTO) {
        // TODO Auto-generated method stub
        List<String> cityIds = cityRepository.getCityIds();
        String id = cityIds.get(cityIds.size() - 1);
        String ch = "c";
        id = id.substring(1);
        int cityId = Integer.parseInt(id);
        if (cityId < 9) {
            ch += "0";
        }
        cityId++;

        City city = new City();
        city.setCityName(cityDTO.getCityName());
        city.setCityId(ch + cityId);
        city.setCityStatus("active");
        City response = cityRepository.save(city);
        return response;

    }

    @Override
    @Transactional
    public City deleteCity(CityDTO cityDTO) {
        // TODO Auto-generated method stub

        City city = cityRepository.findByCityNameAndCityStatus(cityDTO.getCityName(), "active");
        if (city == null) {
            return city;
        }
        city.setCityName(city.getCityName());
        city.setCityStatus("inactive");
        city.setCityId(city.getCityId());
        City response = cityRepository.save(city);
        return response;

    }

}
