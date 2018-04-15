package com.mymovieportal.mymovieportal.serviceImpl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mymovieportal.dao.CityDAO;
import com.mymovieportal.model.City;
import com.mymovieportal.service.CityService;
import com.mymovieportal.service.impl.CityServiceImpl;

public class CityServiceImplUnitTest {

    @InjectMocks
    private CityService cityService = new CityServiceImpl();

    @Mock
    private CityDAO cityDao;

    private static String CITYID = "c01";

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCity() {
        City city = new City();
        city.setCityId("c01");
        city.setCityName("Indore");

        when(cityDao.getCity(anyString())).thenReturn(city);

        City city2 = cityService.getCity(CITYID);

        assertEquals(city2.getCityId(), city.getCityId());

    }

    @Test
    public void testGetCityInvalid() {

        City city = new City();
        when(cityDao.getCity(CITYID)).thenReturn(city);
        City city2 = cityService.getCity(CITYID);
        assertNull(city2.getCityId());
    }

    @Test
    public void testGetCities() {
        List<City> cities = new ArrayList<>();
        when(cityDao.getCities()).thenReturn(cities);
        List<City> cityList = cityService.getCities();
        assertNotNull(cityList);
    }

    @Test
    public void testGetCityNameOnly() {

        String cityName = "Indore";
        when(cityDao.getCityNameOnly(anyString())).thenReturn(cityName);
        String cityN = cityService.getCityNameOnly("c01");

        assertSame(cityN, cityName);
    }

    @Test
    public void testGetCityNameOnlyInvalid() {

        String cityName = null;
        when(cityDao.getCityNameOnly(anyString())).thenReturn(cityName);
        String cityN = cityService.getCityNameOnly("00");

        assertNull(cityN);
    }
}
