package com.mymovieportal.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymovieportal.dao.CityDAO;
import com.mymovieportal.model.City;


@Repository
@Transactional
public class CityDAOImpl implements CityDAO {
    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public City getCity(String cityId) {
        // TODO Auto-generated method stub

        try {
            City city = getSession().get(City.class, cityId);
            return city;
        } catch (Exception ex) {
            System.out.println("error in CityDAOImpl getCity() " + ex);
            return null;
        }
    }

    @Override
    public List<City> getCities() {
        // TODO Auto-generated method stub
        Query query = getSession().createQuery("from City");
        List<City> cityList = query.list();
        return cityList;
    }

}
