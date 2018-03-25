package com.mymovieportal.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mymovieportal.dao.TheatreDAO;
import com.mymovieportal.model.Theatre;

@Repository
@Transactional
public class TheatreDAOImpl implements TheatreDAO {

    @Autowired
    private SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public Theatre getTheatre(String theatreId) {
        // TODO Auto-generated method stub
        try {
            Theatre theatre = getSession().get(Theatre.class, theatreId);
            return theatre;
        } catch (Exception ex) {
            System.out.println("error in TheatreDAOImpl getCity() " + ex);
            return null;
        }

    }

    @Override
    public List<Theatre> getTheatres() {
        // TODO Auto-generated method stub
        Query query = getSession().createQuery("from Theatre");
        List<Theatre> theatreList = query.list();
        return theatreList;
    }


    @Override
    public List<Theatre> getTheatresByCity(String cityId) {
        // TODO Auto-generated method stub
        String myquery = "from Theatre where theatre_city_id=:cityId";
        Query query = getSession().createQuery(myquery);
        query.setParameter("cityId", cityId);
        List<Theatre> theatreList = query.list();
        return theatreList;
    }

}
